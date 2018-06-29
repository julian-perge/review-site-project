package org.julian.reviewsiteproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewSitePopulator implements CommandLineRunner
{
	// id, title, imgUrl, category, content, collection of tags
	@Autowired
	private ReviewRepository reviewRepo;
	@Autowired
	private CategoryRepository catRepo;
	@Autowired
	private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception
	{
		Category catAction = catRepo.save(new Category("Action"));
		Category catHorror = catRepo.save(new Category("Horror"));
		Category catAdventure = catRepo.save(new Category("Adventure"));
		
		Tag tagWar = tagRepo.save(new Tag("War"));
		Tag tagCyborg = tagRepo.save(new Tag("Cyborg"));
		Tag tagTimeTravel = tagRepo.save(new Tag("Time Travel"));
		Tag tagHotel = tagRepo.save(new Tag("Hotel"));
		Tag tagTwins = tagRepo.save(new Tag("Identical Twins"));
		Tag tagIsolate = tagRepo.save(new Tag("Isolation"));
		Tag tagDinos = tagRepo.save(new Tag("Dinosaur"));
		Tag tagThemeParks = tagRepo.save(new Tag("Theme Park"));
		Tag tagIsland = tagRepo.save(new Tag("Island"));
		Tag tagTesting = tagRepo.save(new Tag("Testing"));
		
		Review terminatorReview 
			= reviewRepo.save(new Review("Terminator", "terminatorReviewImg", "ayyy lmao", 
					catAction, tagWar, tagCyborg, tagTimeTravel, tagTesting));
				
		Review theShiningReview
			= reviewRepo.save(new Review("The Shining", "theShiningReviewImg", "The Shining is scary", 
					catHorror, tagHotel, tagTwins, tagIsolate, tagTesting));
		
		Review jurassicParkReview 		
			= reviewRepo.save(new Review("Jurassic Park", "jurassicParkImg", "Dinos are adorable without teeth", 
					catAdventure, tagDinos, tagThemeParks, tagIsland, tagTesting));
	}
}
