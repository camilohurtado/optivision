package com.optivision.webapp.ui.sales;

import com.optivision.webapp.product.dto.Product;
import com.optivision.webapp.product.enumerator.*;
import com.optivision.webapp.product.service.ProductService;
import com.optivision.webapp.sale.dto.Sale;
import com.optivision.webapp.sale.dto.SaleItem;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import com.vaadin.flow.data.binder.ValidationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SaleItemForm extends FormLayout {

    private final Select<String> name = new Select<>();
    private final Select<ProductType> type = new Select<>(ProductType.values());
    private final Select<String> make = new Select<>();
    @PropertyId("product.color")
    private final Select<String> color = new Select<>();
    @PropertyId("product.materialEstuche")
    private final Select<CaseMaterial> caseMaterialSelect = new Select<>(CaseMaterial.values());
    @PropertyId("product.caseStyle")
    private final Select<CaseStyle> caseStyleSelect = new Select<>(CaseStyle.values());
    @PropertyId("product.tipoMarco")
    private final Select<String> glassFrameSelect = new Select<String>(Arrays.stream(GlassFrame.values())
            .map(glassFrame -> glassFrame.getValue())
            .toArray(String[]::new)
    );
    @PropertyId("product.materialMarco")
    private final Select<GlassFrameMaterial> glassFrameMaterialSelect = new Select<>(GlassFrameMaterial.values());
    @PropertyId("product.dioptria")
    private final Select<String> dioptriaSelect = new Select<>();
    @PropertyId("product.mililitrosLiquido")
    private final Select<Long> mililitrosLiquido = new Select<>();

    private final Button accept = new Button("Aceptar");
    private final Button cancel = new Button("Cancel");
    private boolean formState = false;

    private final Binder<SaleItem> binder = new Binder<>(SaleItem.class);
    private final SaleForm saleForm;

    private final ProductService productService;

    private final List<Product> products;

    public SaleItemForm(SaleForm saleForm, ProductService productService) {
        this.saleForm = saleForm;
        this.productService = productService;
        products = productService.getAllProducts();

        setResponsiveSteps(new ResponsiveStep("25em", 2));

        initFormFields();

        HorizontalLayout buttons = new HorizontalLayout(accept, cancel);
        buttons.setSizeFull();

        //add(fields);
        add(type, name, make, mililitrosLiquido, color, caseMaterialSelect, caseStyleSelect, glassFrameMaterialSelect, glassFrameSelect, dioptriaSelect);
        add(buttons);

        setActionButtonsEvents();
        binder.bindInstanceFields(this);
    }

    private void setActionButtonsEvents(){
        this.accept.addClickListener(buttonClickEvent -> {
           SaleItem product = binder.getBean();
           Sale currentSale = saleForm.getCurrentSale();
           currentSale.addItemsToSale(product);

            try {
                saleForm.updateCurrentSale(currentSale);
            } catch (ValidationException e) {
                e.printStackTrace();
            }

        });
    }

    /**
     * Set initial properties of the form fields
     */
    private void initFormFields(){
        this.name.setVisible(false);
        this.name.setLabel("Nombre del producto");
        this.make.setVisible(false);
        this.make.setLabel("Marca");
        this.type.setVisible(true);
        this.type.setLabel("Tipo de producto");
        this.color.setVisible(false);
        this.color.setLabel("Color");
        this.glassFrameSelect.setVisible(false);
        this.glassFrameSelect.setLabel("Tipo de marco");
        this.glassFrameMaterialSelect.setVisible(false);
        this.glassFrameMaterialSelect.setLabel("Material del marco");
        this.caseMaterialSelect.setVisible(false);
        this.caseMaterialSelect.setLabel("Material del estuche");
        this.dioptriaSelect.setVisible(false);
        this.dioptriaSelect.setLabel("Dioptria");
        this.caseStyleSelect.setVisible(false);
        this.caseStyleSelect.setLabel("Estilo del estuche");
        this.mililitrosLiquido.setVisible(false);

        organizeFormByProductTypeSelection();
    }
    /**
     * When user select product type or does not select any product type
     * the form items should make visible and have its information for
     * that selection.
     *
     */
    private void organizeFormByProductTypeSelection(){

        type.addValueChangeListener(e -> {
            ProductType productType = type.getValue();

            if (productType == null){
                name.setVisible(false);
                type.setVisible(true);
                color.setVisible(false);
                glassFrameSelect.setVisible(false);
                glassFrameMaterialSelect.setVisible(false);
                caseMaterialSelect.setVisible(false);
                dioptriaSelect.setVisible(false);
                caseStyleSelect.setVisible(false);
                mililitrosLiquido.setVisible(false);
                return;
            }

            switch (productType) {
                case MARCO:
                    name.setVisible(true);
                    make.setVisible(true);
                    color.setVisible(true);
                    glassFrameSelect.setVisible(true);
                    glassFrameMaterialSelect.setVisible(true);
                    caseMaterialSelect.setVisible(false);
                    dioptriaSelect.setVisible(false);
                    caseStyleSelect.setVisible(false);
                    mililitrosLiquido.setVisible(false);

                    List<Product> glassFrames = filterProductsByType(productType);
                    make.setItems(getMakeListOfString(glassFrames));
                    name.setItems(getNamesListOfString(glassFrames));
                    color.setItems(getColorListOfString(glassFrames));

                    break;
                case ESTUCHE:
                    name.setVisible(true);
                    make.setVisible(false);
                    color.setVisible(false);
                    glassFrameSelect.setVisible(false);
                    glassFrameMaterialSelect.setVisible(false);
                    dioptriaSelect.setVisible(false);
                    caseMaterialSelect.setVisible(true);
                    caseStyleSelect.setVisible(true);
                    mililitrosLiquido.setVisible(false);

                    List<Product> cases = filterProductsByType(productType);
                    name.setItems(getNamesListOfString(cases));

                    break;
                case AUMENTO:
                    name.setVisible(true);
                    dioptriaSelect.setVisible(true);
                    make.setVisible(true);
                    color.setVisible(true);
                    glassFrameSelect.setVisible(true);
                    glassFrameMaterialSelect.setVisible(true);
                    caseMaterialSelect.setVisible(false);
                    caseStyleSelect.setVisible(false);
                    mililitrosLiquido.setVisible(false);

                    List<Product> augmentedGlasses = filterProductsByType(productType);
                    name.setItems(getNamesListOfString(augmentedGlasses));
                    make.setItems(getMakeListOfString(augmentedGlasses));
                    color.setItems(getColorListOfString(augmentedGlasses));

                    break;
                case LENTES:
                    name.setVisible(false);
                    dioptriaSelect.setVisible(false);
                    make.setVisible(false);
                    color.setVisible(true);
                    glassFrameSelect.setVisible(false);
                    glassFrameMaterialSelect.setVisible(false);
                    caseMaterialSelect.setVisible(false);
                    caseStyleSelect.setVisible(false);

                    //Fill color select with freshlook data
                    //Decide if ENUM or DB

                    break;
                case LIQUIDO:
                    name.setVisible(true);
                    dioptriaSelect.setVisible(false);
                    make.setVisible(false);
                    color.setVisible(false);
                    glassFrameSelect.setVisible(false);
                    glassFrameMaterialSelect.setVisible(false);
                    caseMaterialSelect.setVisible(false);
                    caseStyleSelect.setVisible(false);
                    mililitrosLiquido.setVisible(true);

                    List<Product> liquidos = filterProductsByType(productType);
                    name.setItems(getNamesListOfString(liquidos));
                    mililitrosLiquido.setItems(getListOfMililitros(liquidos));

                    break;
            }
        });
    }

    private List<Product> filterProductsByType(ProductType productType) {
        return products.stream()
                .filter(product -> product.getTipoProducto().equalsIgnoreCase(productType.getValue()))
                .collect(Collectors.toList());
    }

    private List<String> getNamesListOfString(List<Product> list) {
        return list
                .stream()
                .map(product -> product.getNombreProducto() + " - " + product.getMarca())
                .collect(Collectors.toList());
    }

    private List<String> getMakeListOfString(List<Product> list) {
        return list
                .stream()
                .map(product -> product.getMarca())
                .collect(Collectors.toList());
    }

    private List<String> getColorListOfString(List<Product> list) {
        return list
                .stream()
                .map(product -> product.getColor())
                .collect(Collectors.toList());
    }

    private List<Long> getListOfMililitros(List<Product> list){
        return list.stream()
                .map(product -> Long.valueOf(product.getMililitrosLiquido()))
                .collect(Collectors.toList());
    }


    /**
     * Form logic to show/hide itself
     * @param - sale {@Link - SaleItem}
     */
    public void formShow(SaleItem saleItem){
        saleItem.setSaleId(saleForm.getCurrentSale().getId());
        binder.setBean(saleItem);

        if(saleItem == null){
            setVisible(false);
        }else{
            setVisible(true);
            type.focus();
        }
    }

    public boolean isOpen(){
        return formState;
    }

    public void setState(boolean state){
        this.formState = state;
    }
}
