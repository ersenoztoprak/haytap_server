package main;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ersen.controller.CustomerResource;
import com.ersen.entity.Customer;
import com.ersen.entity.builder.CustomerBuilder;
import com.ersen.repository.CustomerRepository;


@RunWith(MockitoJUnitRunner.class)
public class CustomerResourceUnitTests {

    @Mock
    private CustomerRepository customerRepository;
        
    private MockMvc mockMvc;
    
    private static final long ID = 1L;
    private static final long ID2 = 2L;
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new CustomerResource(customerRepository)).build();
    }
    
    @Test
    public void getCustomers_Listed_ShouldReturnResponseStatusOK() throws Exception {
        Customer c1 = new CustomerBuilder().id(ID).get();
        Customer c2 = new CustomerBuilder().id(ID2).get();
        
        when(customerRepository.findAll()).thenReturn(Arrays.asList(c1, c2));
        mockMvc.perform(get("/customer/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.", hasSize(2)));
    }
    
    @Test
    public void getCustomer_Get_ShouldReturnResponseStatusOK() throws Exception {
        Customer c1 = new CustomerBuilder().id(ID).get();
        
        when(customerRepository.getById(ID)).thenReturn(c1);
        mockMvc.perform(get("/customer/{id}", ID).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.id").value((int)ID));
    }
    
    @Test
    public void createCustomer_Created_ShouldReturnResponseStatusOK() throws Exception {
        Customer c1 = new CustomerBuilder().id(ID).get();
        
        when(customerRepository.save(c1)).thenReturn(c1);
        mockMvc.perform(post("/customer/").contentType(MediaType.APPLICATION_JSON).content(WebTestUtil.convertObjectToJsonBytes(c1))).andExpect(status().isOk());
    }
    
    @Test
    public void deleteCustomer_Deleted_ShouldReturnResponseStatusOK() throws Exception {
        mockMvc.perform(delete("/customer/{id}", ID).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
    
    @Test
    public void updateCustomer_Updated_ShouldReturnResponseStatusOK() throws Exception {
    	Customer c1 = new CustomerBuilder().id(ID).get();
        mockMvc.perform(put("/customer/{id}", ID).contentType(MediaType.APPLICATION_JSON).content(WebTestUtil.convertObjectToJsonBytes(c1))).andExpect(status().isOk());
    }
}
