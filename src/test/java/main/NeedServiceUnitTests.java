package main;

import static org.hamcrest.CoreMatchers.isA;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ersen.entity.Category;
import com.ersen.entity.User;
import com.ersen.entity.builder.PersonalBuilder;
import com.ersen.entity.domain.Personal;
import com.ersen.entity.dto.request.CreateNeedDTO;
import com.ersen.entity.enums.NeedType;
import com.ersen.exception.InvalidRequestParametersException;
import com.ersen.repository.NeedRepository;
import com.ersen.service.CategoryService;
import com.ersen.service.NeedService;
import com.ersen.service.UserService;
import com.ersen.service.impl.NeedServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class NeedServiceUnitTests {

	private NeedService needService;
	@Mock
	private NeedRepository needRepository;

	@Mock
	private UserService userService;

	@Mock
	private CategoryService categoryService;
	
	@Before
	public void setup() {
		this.needService = new NeedServiceImpl(userService, categoryService, needRepository);
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void create_WithNullParams_ShouldThrowException () {
		needService.create(null);
	}
	
	@Test(expected = InvalidRequestParametersException.class)
	public void create_PayableWitoutAmount_ShouldThrowException () {
		CreateNeedDTO dto = new CreateNeedDTO();
		
		dto.setTitle("aaa");
		dto.setDescription("bbb");
		dto.setCategoryId(1L);
		dto.setType(NeedType.PAYABLE);
		dto.setOwnerId(1L);
		
		User user = new PersonalBuilder().id(dto.getOwnerId()).get();
		Category category = new Category();
		category.setId(dto.getCategoryId());
		
		when(userService.getPersonalUser(dto.getOwnerId())).thenReturn((Personal)user);
		when(categoryService.getCategory(dto.getCategoryId())).thenReturn(category);
		
		needService.create(dto);
	}
}
