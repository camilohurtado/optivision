package com.optivision.webapp.ui.sales;

import com.optivision.webapp.product.service.ProductService;
import com.optivision.webapp.sale.dto.Sale;
import com.optivision.webapp.sale.dto.SaleItem;
import com.optivision.webapp.sale.service.SalesService;
import com.optivision.webapp.ui.MainView;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.Autocomplete;
import com.vaadin.flow.function.SerializableSupplier;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import com.vaadin.flow.component.textfield.TextField;
import org.vaadin.crudui.form.CrudFormFactory;
import org.vaadin.crudui.form.impl.field.provider.DefaultFieldProvider;
import org.vaadin.crudui.form.impl.form.factory.DefaultCrudFormFactory;

import java.time.LocalDate;

@Route(value = "sales", layout = MainView.class)
@PageTitle("Ventas")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "sales", layout = MainView.class)
public class SalesView extends VerticalLayout {

    private final SalesService salesService;
    private final ProductService productService;
    GridCrud<Sale> crud;

    public SalesView(SalesService salesService, ProductService productService) {
        this.productService = productService;
        this.salesService = salesService;

        crud = new GridCrud<>(Sale.class);

        // You can initialise any data required for the connected UI components here.
        crud.setFindAllOperation(() -> salesService.getSalesByDate(LocalDate.now()));
        crud.getGrid().setPageSize(7);

        crud.getGrid().removeColumnByKey("id");
        crud.getGrid().removeColumnByKey("state");
        crud.getGrid().removeColumnByKey("type");
        crud.getGrid().removeColumnByKey("creationDate");

        crud.getCrudFormFactory().setDisabledProperties(CrudOperation.ADD, "total");
        //crud.setClickRowToUpdate(true);
        crud.setUpdateOperationVisible(true);
        crud.setDeleteOperationVisible(true);
        //crud.setAddOperation(sale -> salesService.doSale(sale));

        crud.getCrudFormFactory().setDisabledProperties(CrudOperation.UPDATE, "creationDate", "id", "state", "type");
        crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "items", "paid", "patientName", "pending", "total");
        crud.getCrudFormFactory().setFieldProvider("items", () -> {
            return  new SalesItemsField(productService);
        });


        add(crud);
    }
}

@Route("")
class SalesItemsField extends CustomField<SaleItem>{


    GridCrud<SaleItem> saleItemGridCrud;
    HorizontalLayout horizontalLayout;
    private final ProductService productService;

    public SalesItemsField(ProductService productService){

        this.productService = productService;
        horizontalLayout = new HorizontalLayout();
        horizontalLayout.setHeightFull();

        //saleItemGridCrud = new CustomGridCrud<>(SaleItem.class);
        saleItemGridCrud = new GridCrud<>(SaleItem.class);
        saleItemGridCrud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "name", "type", "price");

        SaleItem object = saleItemGridCrud.getCrudFormFactory().getNewInstanceSupplier().get();
        object.getType();

        saleItemGridCrud.getCrudFormFactory().setFieldProvider("name", () -> {
            Select<String> select = new Select<>();
            select.setItems("TEST");
            return select;
        });
        saleItemGridCrud.getCrudFormFactory().setDisabledProperties("price");
        horizontalLayout.add(saleItemGridCrud);
        add(horizontalLayout);

    }

    @Override
    protected SaleItem generateModelValue() {
        return SaleItem.builder().build();
    }

    @Override
    protected void setPresentationValue(SaleItem saleItem) {
        return;
    }
}

class CustomGridCrud<T> extends  GridCrud<T>{

    protected TextField searchTextField = new TextField();


    public CustomGridCrud(Class<T> domainType) {
        super(domainType);
        searchTextField.setPlaceholder("Ingrese nombre o tipo de producto");
        this.crudLayout.addToolbarComponent(this.searchTextField);
    }
}
