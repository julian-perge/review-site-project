package org.julian.reviewsiteproject.repository;

import java.util.Formatter;

import org.julian.reviewsiteproject.entities.Category;
import org.julian.reviewsiteproject.entities.Review;
import org.julian.reviewsiteproject.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewSitePopulator implements CommandLineRunner
{
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
			= reviewRepo.save(new Review("Terminator", "terminatorReviewImg.jpg", terminatorContent + "\nSource: https://www.imdb.com/review/rw0216010/", 
					catAction, tagWar, tagCyborg, tagTimeTravel, tagTesting));
				
		Review theShiningReview
			= reviewRepo.save(new Review("The Shining", "theShiningReviewImg.jpg", theShiningContent, 
					catHorror, tagHotel, tagTwins, tagIsolate, tagTesting));
		
		Review jurassicParkReview 		
			= reviewRepo.save(new Review("Jurassic Park", "jurassicParkImg.jpg", jurassicParkContent, 
					catAdventure, tagDinos, tagThemeParks, tagIsland, tagTesting));
	}
	
	// I know this is really ugly but it's the only way I can think of at the moment to load the content
	// Will rafactor later
	
	private String terminatorContent = "The Terminator is one of those films that no matter if you've seen it or not, you've heard of it, "
			+ "heck you know at least one or two lines without seeing it! This is the movie that blasted then new comer's Arnold Schwartzeneggerr's career, "
			+ "made James Cameron a name in Hollywood, and gave new meaning to a possible dark future that gave us nightmares. "
			+ "I remember the first time I saw this movie, I was just 8 years old and my dad of course walks in saying to cover my eyes at every \"bad\" scene with violence or nudity, "
			+ "needless to say about 70% of the movie he covered my eyes. Finally I got to see it with my mom and I was in love, this wasn't just an action movie, "
			+ "though it is one of the best, it had a story. To think this was all based upon just a quick nightmare that James Cameron had, he didn't have much money, "
			+ "but he had a good script, a great crew on his side to make one of cinema's greatest movies of all time."
			+ "Two men appear in Los Angeles in separate locations, manifesting in sudden, blinding flash-storms of electricity. "
			+ "One is heavily muscular; the other man, slim and wiry. The mysterious muscular man obtains weapons and begins hunting down all women named \"Sarah Connor\", "
			+ "using a phone book to track his targets. He successfully kills the first two of the three listed women. "
			+ "When he attempts to kill the last Sarah Connor, he is stopped by the other man, Kyle Reese who has been sent back in time to protect her. "
			+ "While hiding in a parking garage, Reese explains that the man hunting Sarah is actually a cyborg assassin called a \"Terminator\", built by Skynet, "
			+ "an artificial intelligence network created by Cyberdyne Systems. In the near future, Reese explains, Skynet gained self-awareness, "
			+ "initiated a global takeover of military hardware, and launched a nuclear war against humanity. "
			+ "Skynet ordered that a scant number of humans were to be kept alive in order to be used as slave labor. John Connor, Sarah's son, "
			+ "rallied the few remaining humans and led a resistance movement against the machines. After a grinding campaign, "
			+ "the human resistance was on the verge of victory; in a last-ditch effort, Skynet sent the Terminator back in time to kill Sarah before John was born, "
			+ "preventing the resistance from ever being founded and allowing the machines to win by default. "
			+ "Reese volunteered to follow the Terminator back in time to protect Sarah; after his use of the time transportation equipment, "
			+ "it was to be destroyed by the resistance in order to prevent further Terminators from going back in time. The Terminator feels no pain, has no emotions, "
			+ "and will stop at nothing to accomplish its mission.\n"
			+ "The Terminator is personally one of my favorite movies of all time, I think because this movie really is something special. Yeah, the effects are very 80's, but for the time and even to this day, I think the special effects are much better than the CGI crud we get in today's cinema. This has everything: action, romance, horror, sci-fi, and even some dark humor. The reason why Arnold's \"I'll be back\" is so famous is not just because of his accent, but because you knew that something bad was coming. Kyle Reese's \"Come with me if you want to live\" is classic as well. If you haven't seen The Terminator, I highly recommend this movie, it's an incredible one that is sure to deliver entertainment to the fullest. This is one of the greatest movies of all time and I'm sure that you will not be disappointed, if you are, get a CAT scan.\n" + 
			"";
	
	private String jurassicParkContent = "In the year 1993, Hollywood saw something unlike anything else, the film Jurassic Park. Never before 1993 had dinosaurs been so breathtaking and realistic on the silver screen.\r\n" + 
			"\r\n" + 
			"The plot is very original. A group of scientists cloned dinosaurs, and are about to open an amusement park where people can see the dinosaurs. The creator John Hammond(Richard Attenborough) invites a group of people, along with his grandchildren, to see the dinos and enjoy a relaxing time at the park. Could anything go wrong, at the time it doesn't seem like it, but something else is going on. Employee Dennis Nedry is planning to steal dinosaur embryos. In order to do this, he causes a security breakdown so he can get the embryos and escape. He isn't the only one that can escape, as hungry dinos also escape. After this, everyone on the island is in danger, and loose dinosaurs are everywhere. That is where the fun in Jurassic Park comes in.\r\n" + 
			"\r\n" + 
			"This is an underrated movie according to the IMDb ratings. It isn't even in the top 250. Today, people don't appreciate it as much, mainly due to the fact that other movies like it have been made. Growing up in the 90's, this was one of my favorite movies. As a kid, I only watched it to see the dinosaurs, as I didn't understand a whole lot of it. Today, I realize how great the plotting and suspense are.\r\n" + 
			"\r\n" + 
			"This spawned two sequels. The second one wasn't bad, but the third wasn't very good. I would recommend seeing the second after this, but the third is passable.\r\n" + 
			"\r\n" + 
			"The story is great, how at first we see how the magic was created, and then later we see the magic turn into a disaster, in which everyone's life is at stake.\r\n" + 
			"\r\n" + 
			"The special effects are still good today, but they were revolutionary for back in 1993. The acting is good, and the ensemble cast is great. All of the action sequences are perfectly executed, creating plenty of suspense and tension.\r\n" + 
			"\r\n" + 
			"Younger kids may get scared by this, as I remember a lot of young kids being scared by it in 1993. If kids aren't scared by dinosaurs, they will probably enjoy the movie.\r\n" + 
			"\r\n" + 
			"I highly recommend Jurassic Park. It is quite underrated in my opinion, it deserves more credit than it gets.\r\n" + 
			"\r\n" + 
			"Watch this at all costs if you have somehow missed it and see what everyone was amazed about back in 1993.\r\n" + 
			"\r\n" + 
			"Enjoy - Source: https://www.imdb.com/review/rw1165979/";
	
	private String theShiningContent = "The Shining is a masterclass in film-making and a staple of popular culture. I, personally, cannot stand horror films. I don't like to feel scared, and I don't like to have my emotions manipulated by scary monsters, scary music, scary lighting, etc. I feel like horror is an easy genre - it's easy to scare some people, and people go to movies hoping to feel something, so why not fear?\r\n" + 
			"\r\n" + 
			"But, I had heard a lot about The Shining. I decided I would look up the plot and watch some clips so I wouldn't be caught off-guard by anything, and I could just appreciate the characters, directing, cinematography, etc.\r\n" + 
			"\r\n" + 
			"Despite knowing everything that would happen, the film was unbelievably engaging. I couldn't take my eyes off the screen. Jack Nicholson, of course, steals the show with one of the most iconic performances ever, and the other actors were decent, but the real star was Kubrick himself. Every shot, every set, the sound design, and everything has his fingerprints all over it, and it is such a delight to watch. When Jack advances up the stairs demanding the bat from Shelley Duval, I grinned from ear to ear because everything in that moment was just perfect in film.\r\n" + 
			"\r\n" + 
			"The movie, like all others, has problems. In my opinion, the Grady girls and the bloody elevator do not hold up. I knew they were coming from the summaries I had read, so I knew what to expect, so the only reason I could see them as being scary or unsettling is if the viewer was caught off-guard. If you're pretty feminist, you're not going to like Shelley Duval's character, as she is a pretty weak character.\r\n" + 
			"\r\n" + 
			"All in all, this film is fantastically-made, a cinematic and acting delight, and a gripping horror film that is considered a classic for a reason. - Source: https://www.imdb.com/review/rw3807000/";
}
