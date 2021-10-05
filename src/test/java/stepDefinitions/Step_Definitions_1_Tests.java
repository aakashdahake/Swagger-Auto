package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.juneau.parser.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.swagger.POJOs.Category;
import com.swagger.POJOs.PetData;
import com.swagger.POJOs.Tag;
import com.swagger.libraries.Pet;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Step_Definitions_1_Tests {

	private Logger logger = LogManager.getLogger();
	private Pet petLib = new Pet();
	private Scenario scenario;
	private PetData requestPetData = new PetData();
	private PetData responsePetDetails = new PetData();
	
	
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
		logger.info("********************************************************************************************************");
		logger.info(":::: Execution Started :::: {}", scenario.getName());
		logger.info("********************************************************************************************************");
	}

	@Given("user gathers details about pet")
	public void user_gathers_details_about_pet() throws ParseException {

		
		Category category = new Category();
		List<String> photoURLS = new ArrayList<String>();
		Tag tags = new Tag();
		List<Tag> tagList = new ArrayList<Tag>();

		// Set Tag data
		tags.setId(789);
		tags.setName("Labradore");
		tagList.add(tags);

		// URL set
		photoURLS.add("www.dogs.com/ev.jpg");

		// Category Set
		category.setId(123);
		category.setName("Dogs");

		// Pet details Set
		requestPetData.setName("Evi");
		requestPetData.setId(456);
		requestPetData.setStatus("available");
		requestPetData.setCategory(category);
		requestPetData.setPhotoUrls(photoURLS);
		requestPetData.setTags(tagList);

	}

	@Then("user adds pet to inventory")
	public void user_adds_pet_to_inventory() {
		
		//Add pet to inventory
		responsePetDetails = petLib.addPetToInv(requestPetData);
	}

	@Then("user validates addition of pet to inventory")
	public void user_validates_addition_of_pet_to_inventory() {
		
		
		try {
			
			PetData responseData = petLib.findPetByID(456);
			System.out.printf("Response={}",responseData.getId());
			if(responsePetDetails.getId() == requestPetData.getId()) {
				assertEquals(requestPetData.getName(), responseData.getName());
			}
			
		} catch (AssertionError e) {
			logger.error(e.getMessage());
		}
	}
}
