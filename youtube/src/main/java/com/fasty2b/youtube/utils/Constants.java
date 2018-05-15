package com.fasty2b.youtube.utils;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.common.collect.ImmutableList;




public class Constants {
	public static final int SUCCESS_CODE = 0;
	public static final int ERROR_CODE = -1;
	public static final String SUCCESS = "Success";

	public static final String LOGIN_FAIL_MESSAGE = "Username/ password is not correct";

	public static final String ACCESS_TOKEN_IS_REQUIRE = "Please give me the access token, men!";

	/* Auth */
	/**
	 * Define a global instance of the HTTP transport.
	 */
	public static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

	/**
	 * Define a global instance of the JSON factory.
	 */
	public static final JsonFactory JSON_FACTORY = new JacksonFactory();

	public static final ImmutableList<String> RANDOM_KEYWORDS_CONSTANTS = ImmutableList.of("Lovely", "Wonderful",
			"The best", "The Legend", "Supper", "Hero", "Excellent", "Perfect", "Awsome");

	public static final ImmutableList<String> DESCRIPTION_ONE_CONSTANTS = ImmutableList.of("In this assortment",
			"In this lot", "In this list", "In this set", "In this playlist", "In this chain", "In this assemblage",
			"In this collection", "In this selection", "In this sequence", "In this series", "In this suit",
			"In this compilation", "In this mess", "In this batch", "In this group");

	public static final ImmutableList<String> DESCRIPTION_TWO_CONSTANTS = ImmutableList.of(
			", I pointed out large numbers of awesome videos", ", I chose some inviting videos about ",
			", I compiled many inviting videos about ", ", I collected a few amazing videos about ",
			", I shared plenty of hot videos about ter.", ", I added some appealing videos about ",
			", I saved many attractive videos about ", ", I collected a few dreamy videos about ",
			", I collected a couple of alluring videos about ", ", I compiled plenty of delightful videos about ",
			", I pointed out a bunch of marvelous videos about", ", I chose a couple of stunning videos about ",
			", I chose various splendid videos about ", ", I showed some delightful videos about",
			", I collected various dazzling videos about", ", I gathered a few marvelous videos about",
			", I collected various dazzling videos about", ", I gathered a few marvelous videos about",
			", I gathered various marvelous videos about", ", I chose a few dishy videos about",
			", I collected large numbers of superb videos about", ", I collected a lot of gorgeous videos about",
			", I shared a couple of delicate videos about", ", I featured various cool videos about",
			", I added plenty of appealing videos about", ", I compiled various appealing videos about",
			", I added a bunch of amazing videos about", ", I featured many dazzling videos about",
			", I gathered plenty of adorable videos about", ", I pointed out a couple of delightful videos about",
			", I chose a lot of attractive videos about", ", I chose plenty of wonderful videos about",
			", I chose various marvelous videos about", ", I shared large numbers of exquisite videos about",
			", I pointed out plenty of pleasing videos about", ", I pointed out a couple of marvelous videos about",
			", I chose some dreamy videos about", ", I collected a bunch of lovable videos about",
			", I saved large numbers of sexy videos about", ", I shared some stunning videos about",
			", I saved plenty of beautiful videos about", ", I featured a couple of ambrosial videos about",
			", I showed a few fascinating videos about", ", I pointed out a few charming videos about",
			", I saved plenty of sexy videos about", ", I pointed out a few dreamy videos about",
			", I collected some elegant videos about", ", I showed many pleasing videos about",
			", I pointed out large numbers of gorgeous videos about",
			", I gathered large numbers of awesome videos about");

	public static final ImmutableList<String> DESCRIPTION_THREE_CONSTANTS = ImmutableList.of(
			"I hope this lot can make you joy and a lot of fun.", "I hope this list can make you relax and have fun.",
			"I hope this set can get you a lot of fun", "I hope this playlist can offer you joy and a lot of fun",
			"I hope this chain can give you relax and have fun",
			"I hope this assemblage can give you joy and a lot of fun",
			"I hope this collection can make you a lot of fun",
			"I hope this selection can offer you relax and have fun", "I hope this sequence can give you a lot of fun",
			"I hope this series can get you a lot of fun", "I hope this suit can help you relax and have fun",
			"I hope this assemblage can get you relax and have fun",
			"I hope this selection can give you relax and have fun",
			"I hope this sequence can get you relax and have fun", "I hope this playlist can make you a lot of fun",
			"I hope this compilation can offer you a lot of fun", "I hope this mess can get you a lot of fun",
			"I hope this series can bring you relax and have fun", "I hope this batch can offer you joy and fun",
			"I hope this assemblage can help you a lot of fun", "I hope this assemblage can make you joy and fun",
			"I hope this list can help you joy and a lot of fun", "I hope this playlist can bring you joy and fun",
			"I hope this suit can get you a lot of fun", "I hope this sequence can help you joy and a lot of fun",
			"I hope this assortment can give you a lot of fun",
			"I hope this selection can bring you relax and have fun", "I hope this set can help you relax and have fun",
			"I hope this assortment can make you relax and have fun", "I hope this chain can offer you a lot of fun",
			"I hope this list can offer you joy and fun", "I hope this series can help you joy and a lot of fun",
			"I hope this group can bring you relax and have fun.", "I hope this mess can offer you a lot of fun",
			"I hope this batch can get you a lot of fun", "I hope this group can get you relax and have fun",
			"I hope this playlist can make you joy and a lot of fun", "I hope this batch can make you joy and fun",
			"I hope this assemblage can give you joy and fun", "I hope this series can make you a lot of fun",
			"I hope this lot can make you joy and fun", "I hope this lot can help you joy and a lot of fun",
			"I hope this chain can get you a lot of fun", "I hope this sequence can offer you joy and a lot of fun",
			"I hope this chain can offer you joy and fun", "I hope this sequence can bring you relax and have fun"

	);

	public static final ImmutableList<String> DESCRIPTION_FOUR_CONSTANTS = ImmutableList.of(
			"Just have a sit and enjoy by watching them and listen to the sexy music.",
			"Just sit back and enjoy by watching them and listen to the soft music.",
			"Just have a cup of coffee and enjoy by watching them and listen to the extreme music.",
			"Just relax with by watching them and listen to the great music.",
			"Just focus and enjoy by watching them and listen to the cool music.",
			"Just take it easy and enjoy by watching them and listen to the fantastic music.",
			"Just calm down and enjoy by watching them and listen to the fabulous music.",
			"Just have a cup of coffee and enjoy by watching them and listen to the extreme music.",
			"Just get something to eat and enjoy by watching them and listen to the great music.",
			"Just enjoy by watching them and listen to the soft music.",
			"Just take it easy and enjoy by watching them and listen to the fabulous music.",
			"Just enjoy by watching them and listen to the relaxing music.",
			"Just focus and enjoy by watching them and listen to the great music.",
			"Just relax with by watching them and listen to the soft music.",
			"Just sit back and enjoy by watching them and listen to the awesome music.",
			"Just have a cup of coffee and enjoy by watching them and listen to the lovely music.",
			"Just have a sit and enjoy by watching them and listen to the extreme music.",
			"Just relax with by watching them and listen to the hot music.",
			"Just sit back and enjoy by watching them and listen to the fantastic music.",
			"Just have a cup of coffee and enjoy by watching them and listen to the relaxing music.",
			"Just enjoy by watching them and listen to the trending music.",
			"Just have a sit and enjoy by watching them and listen to the soft music.",
			"Just enjoy by watching them and listen to the good music.",
			"Just focus and enjoy by watching them and listen to the relaxing music.",
			"Just have a sit and enjoy by watching them and listen to the good music.",
			"Just have a cup of coffee and enjoy by watching them and listen to the good music.",
			"Just take it easy and enjoy by watching them and listen to the soft music.",
			"Just take it easy and enjoy by watching them and listen to the relaxing music.",
			"Just have a cup of coffee and enjoy by watching them and listen to the cool music.",
			"Just have a cup of coffee and enjoy by watching them and listen to the fantastic music.",
			"Just have some drink and enjoy by watching them and listen to the hot music.",
			"Just focus and enjoy by watching them and listen to the music.",
			"Just get something to eat and enjoy by watching them and listen to the awesome music.",
			"Just have a sit and enjoy by watching them and listen to the relaxing music.",
			"Just have a cup of coffee and enjoy by watching them and listen to the fabulous music.",
			"Just have some drink and enjoy by watching them and listen to the awesome music.",
			"Just have a cup of coffee and enjoy by watching them and listen to the music.",
			"Just take it easy and enjoy by watching them and listen to the great music.",
			"Just get something to eat and enjoy by watching them and listen to the hot music.",
			"Just relax with by watching them and listen to the fabulous music."

	);

	public static final ImmutableList<String> DESCRIPTION_FIVE_CONSTANTS = ImmutableList.of(
			"Large numbers of new collections in 2018 and later.", "Some new films in 2018 and later.",
			"Many new files in 2018 and later.", "A few new lists in 2018 and later.",
			"Plenty of new videos in 2018 and later.", "Some new collections in 2018 and later.",
			"Many new compilations in 2018 and later.", "A few new tapes in 2018 and later.",
			"A couple of new tapes in 2018 and later.", "Plenty of new vids in 2018 and later.",
			"A bunch of new vids in 2018 and later.", "A couple of new videos in 2018 and later.",
			"Various new sets in 2018 and later.", "Some new videos in 2018 and later.",
			"A few new recordings in 2018 and later.", "Various new films in 2018 and later.",
			"A few new movies in 2018 and later.", "Large numbers of new files in 2018 and later.",
			"A lot of new movies in 2018 and later.", "A couple of new files in 2018 and later.",
			"Various new movies in 2018 and later.", "Plenty of new sets in 2018 and later.",
			"A bunch of new compilations in 2018 and later.", "Many new files in 2018 and later.",
			"Plenty of new lists in 2018 and later.", "A couple of new collections in 2018 and later.",
			"A lot of new tapes in 2018 and later.", "Plenty of new collections in 2018 and later.",
			"Various new tapes in 2018 and later.", "Large numbers of new videos in 2018 and later.",
			"A couple of new lists in 2018 and later", "Some new movies in 2018 and later.",
			"A bunch of new recordings in 2018 and later.", "Large numbers of new recordings in 2018 and later.",
			"Some new sets in 2018 and later", "A couple of new lists in 2018 and later.",
			"A few new vids in 2018 and later.", "A few new files in 2018 and later.",
			"Some new videos in 2018 and later", "Many new videos in 2018 and later.",
			"Large numbers of new films in 2018 and later."

	);

}
