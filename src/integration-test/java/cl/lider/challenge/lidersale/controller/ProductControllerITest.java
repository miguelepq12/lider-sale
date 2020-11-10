package cl.lider.challenge.lidersale.controller;

import cl.lider.challenge.lidersale.LiderSaleApplication;
import cl.lider.challenge.lidersale.entity.product.Product;
import cl.lider.challenge.lidersale.entity.product.ProductBuilder;
import cl.lider.challenge.lidersale.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = LiderSaleApplication.class)
@ComponentScan("cl.lider.challenge.lidersale")
@SpringBootTest
public class ProductControllerITest {

    private MockMvc mockMvc;

    @MockBean
    ProductService service;

    @Autowired
    ProductController productController=new ProductController();

    @Autowired
    private ObjectMapper objectMapper;


    List<Product> products;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .addPlaceholderValue("server.servlet.context-path", "example").build();

        products = new ArrayList<>();
        products.add(new ProductBuilder(1)
                .withBrand("arepera")
                .withDescription("descrption")
                .withPrice(100)
                .withPriceWithDiscount(50)
                .withDiscount(50)
                .withImage("www.lider.cl/catalogo/images/tvIcon.svg")
                .build());
    }

    @Test
    public void getProductsTest() throws Exception {

        Page<Product> pageProduct = new PageImpl<>(products);

        Mockito.when(service.getProducts("", ""))
                .thenReturn(pageProduct);

        MvcResult mvcResult = mockMvc.perform(get("/products")
                .contentType("application/json")
                .param("text", "")
                .param("page", ""))
                .andExpect(status().isOk()).andReturn();
        ;

        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        assertThat(actualResponseBody).isNotEqualToIgnoringWhitespace(
                objectMapper.writeValueAsString(pageProduct));

    }


}
