INSERT INTO users(id, first_name, last_name, date_of_birth, email_address, signed_up_for_newsletter, user_name, password, agreed_to_terms_and_conditions)
VALUES (1, 'Adam', 'Nowak', '1986-12-05', 'adam.nowak@byom.de', true, 'adam', '{noop}adam1', true),
       (2, 'Marzena', 'Bis', '2000-05-29', 'marzenia.bis@byom.de', true, 'marzena', '{noop}marzena1', true),
       (3, 'Judyta', 'Tasior', '1957-04-11', 'judytatasior@byom.de', false, 'judyta', '{noop}judyta1', true),
       (4, 'Radek', 'Sienkiewicz', '1987-07-09', 'radek_sienkiewicz@byom.de', true, 'radek', '{noop}radek1', true),
       (5, 'Marta', 'Nowakowicz', '1999-08-16', 'marta1999@byom.de', false, 'marta', '{noop}marta1', true),
       (6, 'Grzegorz', 'Dec', '1977-02-17', 'grzegorz.dec@byom.de', false, 'grzegorz', '{noop}grzegorz1', true),
       (7, 'Mariusz', 'Szmagara', '1986-03-04', 'mariusz.szmagara@byom.de', true, 'mariusz', '{noop}mariusz1', true),
       (8, 'Mateusz', 'Kozak', '1995-05-12', 'mateusz.kozak@byom.de', false, 'mateusz', '{noop}mateusz', true),
       (9, 'Ola', 'Zenek', '1988-10-08', 'ola_zenek@byom.de', false, 'ola', '{noop}ola1', true),
       (10, 'Adam', 'Witko', '1997-05-11', 'adam.witko@byom.de', false, 'adam123', '{noop}adam2', true);
INSERT INTO role(id, authority, user_id)
VALUES (1, 'ROLE_USER', 1),
       (2, 'ROLE_ADMIN', 2),
       (3, 'ROLE_USER', 3),
       (4, 'ROLE_USER', 4),
       (5, 'ROLE_USER', 5),
       (6, 'ROLE_USER', 6),
       (7, 'ROLE_USER', 7),
       (8, 'ROLE_USER', 8),
       (9, 'ROLE_USER', 9),
       (10, 'ROLE_USER', 10),
       (11, 'ROLE_ADMIN', 7),
       (12, 'ROLE_ADMIN', 10);
INSERT INTO address(id, street_flat_and_house_number, postal_code, city, user_id)
VALUES (1, 'Muzealna 129', '50-035', 'Wrocław', 1),
       (2, 'Sudecka 20', '20-867', 'Lublin', 2),
       (3, 'Załęska Hałda 69', '40-812', 'Katowice', 3),
       (4, 'Popradzka 84', '04-979', 'Warszawa', 4),
       (5, 'Rycerska 64', '93-368', 'Łódź', 5),
       (6, 'Na Skały 86', '35-321', 'Rzeszów', 6),
       (7, 'Trocinowa 57', '04-927', 'Warszawa', 7),
       (8, 'Pl. Żołnierza Polskiego 2', '70-551', 'Szczecin', 8),
       (9, 'Żeromskiego Stefana 15', '90-625', 'Łódź', 9),
       (10, 'Mjra Sucharskiego Henryka 55', '71-075', 'Szczecin', 10);
INSERT INTO recipe(id, title, serves, preparation_time, category, likes_counter, preparation_instructions)
VALUES (1, 'Enfrijoladas with Black Beans, Avocado and Cotija', 4, '30 MINUTES', 'BREAKFAST', 30,
        '<ol>
            <li>Sauté the onion and garlic:</li>
            <p> Heat the olive oil in a large skillet over medium. Add 3/4 of the sliced onion and sauté until nearly tender, about 5 minutes. Add the garlic and sauté to soften, 2 minutes.</p>
            <li>Blend the sauce:</li>
            <p>Transfer the cooked onion and garlic to a blender along with the beans, including the bean liquid, chipotle, lime juice, cumin, salt, and 1/2 cup water. Blend until smooth and creamy. Taste and add more salt if needed, then blend again.</p>
            <li>Heat the sauce:</li>
            <p>Transfer the beans back to the large skillet set over low heat. Cook for 4 to 6 minutes at simmer. The sauce should be the texture of a thick soup. Add more water, if needed, to thin to the appropriate consistency.</p>
            <li>Assemble the dish:</li>
            <p>Use a pair of tongs to heat a tortilla over a gas flame or in a dry skillet set over high heat until it begins to blister. Submerge the tortilla in the bean sauce, smothering it completely. Use a spatula to fold it in half and transfer to a dinner plate. Top with a tablespoon of cotija, a slice or 2 of avocado, and a tangle of raw sliced onions. Continue with remaining tortillas and bean sauce, figuring 2 enfrijoladas per plate.</p>
            <li>Serve:</li>
            <p>Serve immediately with the salsa, cilantro, sour cream and any remaining bean sauce for guests to add as they please.</p>
        </ol>'
                ),
       (2, 'Shakshuka with Feta, Olives, and Peppers', 4, '50 MINUTES' , 'BREAKFAST', 69,
        '<ol>
            <li>Cook the onion and peppers:</li>
            <p>In a large skillet over medium heat, heat the oil. Add the paprika, cumin, and pepper flakes and cook for 30 seconds to a minute to bloom the spices. Add the onion and cook, stirring occasionally, for 3 minutes. Add the garlic, red pepper, and yellow pepper and cook, stirring occasionally, for 15 minutes, or until the vegetables soften.</p>
            <li>Crush the tomatoes and simmer them with the peppers:</li>
            <p>In a bowl, break up the tomatoes with your hands. Add them to the skillet with the salt and cook for 5 minutes. Taste and add more salt, if you prefer.</p>
            <li>Cook the eggs:</li>
            <p>With the back of a spoon or a ladle, make 4 indentations in the sauce. Break an egg into a cup and carefully pour it into and indentation, being careful not to break the yolk. Repeat with the remaining eggs. (You can crack the egg directly into the sauce and skip the cup, but it’s easier to get a an errant egg shell or protect the dish from a bad egg if you use the cup method.) Sprinkle the feta and olives around the eggs. Cover the pan and simmer over medium heat for 8 minutes, or until the whites are set and the yolks are still soft. (If you like your eggs well done, cook for a minute or two longer.)</p>
            <li>To serve:</li>
            <p>Garnish with cilantro leaves and a sprinkling of red pepper flakes. Bring to the table and serve from the pan.</p>
        </ol>'
        ),
       (3, 'Frittata with Potatoes, Red Peppers, and Spinach', 6, '40 MINUTES', 'BREAKFAST', 48,
        '<ol>
            <li>Preheat oven to 400F</li>
            <p> Heat the olive oil in a large skillet over medium. Add 3/4 of the sliced onion and sauté until nearly tender, about 5 minutes. Add the garlic and sauté to soften, 2 minutes.</p>
            <li>Set aside:</li>
            <p>In a small bowl, whisk eggs and milk together</p>
            <li>Cook the onions and garlic:</li>
            <p>Heat olive oil in a 10-inch oven-safe skillet or pan over medium heat. Add the turmeric and stir so that turmeric dissolves into the oil. Add diced onions and cook, stirring occasionally, until they start to soften, about 2 minutes. Add minced garlic and stir for 30 seconds.</p>
            <li>Cook the potatoes and other vegetables:</li>
            <p>Add the potatoes and a generous pinch of salt and cook, stirring occasionally, until some of the slices start to brown, 5 to 6 minutes. Add the red pepper and cook until they start to soften, about 2 minutes. Add scallions and spinach leaves and cook until the leaves start to wilt, stirring occasionally.</p>
            <li>Pour egg mixture into the skillet:</li>
            <p>Reduce heat to medium-low. Cook until the eggs start to set on the bottom, about 2 to 3 minutes</p>
            <li>Place skillet in the oven and bake for 8 to 9 minutes, until the center is set</li>
            <p>Remove skillet from oven with oven mitts. Let frittata cool for 5 minutes before serving. Cut into wedges and season with more salt and some ground pepper, if desired. Frittata will keep refrigerated for 5 days. Leftovers can be eaten chilled or briefly warmed in the microwave.</p>
        </ol>'
        ),
       (4, 'Classic Chicken Salad', 4, '30 MINUTES', 'LUNCH', 52,
        '<ol>
            <li>Poach the chicken (skip if using already cooked chicken):</li>
            <p> Bring a pot with 2 quarts of well salted water (1 tablespoon salt) to a boil. Add the chicken breast (cut into large chunks) and return the water to a simmer. Then turn off the heat, and cover the pot. Let the chicken sit for 15 minutes (time it) or more while you prepare everything else.</p>
            <li>Make the dressing:</li>
            <p>Prepare the chicken salad dressing in a large bowl. Mix together the mayonnaise, preserves, and lemon juice. Taste for the proper balance of sweetness and acidity. The salad dressing should not be too sweet, nor too sour. Add more preserves or lemon juice until you have reached the balance you want. Add salt and pepper to taste.</p>
            <li>Mix ingredients:</li>
            <p>Mix in the chopped celery, bell pepper, olives, red onion, and apple</p>
            <li>Dice the chicken, mix with dressing and vegetables:</li>
            <p>Remove the chicken from the poaching water and dice it. (Or dice already cooked chicken if that is what you are using for this salad.) Mix it in with the dressing and vegetables</p>
            <li>Add lettuce:</li>
            <p>At this point you can make ahead. When ready to serve, fold in the sliced and chopped iceberg lettuce.</p>
        </ol>'
        ),
       (5, 'Ham Salad', 4, '10 MINUTES', 'LUNCH', 23,
        '<ol>
            <li>Mix the ham salad:</li>
            <p> Mix everything with the salt, pepper and cayenne in a large bowl. Taste and add cayenne, salt and black pepper to taste. Serve chilled.</p>
            <li>Serve:</li>
            <p>Serve straight, or mixed in with macaroni, or in a sandwich in a hamburger bun, slider roll, Kaiser roll, regular bread, in a pita or as a wrap. Good with lemonade on a hot day.</p>
        </ol>'
        ),
       (6, 'Best Ever Tuna Salad Sandwich', 1, '5 MINUTES', 'LUNCH', 77,
        '<ol>
            <li>Mix:</li>
            <p>In a medium bowl, mix all of the ingredients until combined.</p>
            <li>Serve:</li>
            <p>Serve tuna salad on toast, either open faced, or in a regular sandwich with lettuce and tomatoes. For a low carb option, serve on sliced lettuce.</p>
        </ol>'
        ),
       (7, 'Classic Baked Chicken', 4, '65 MINUTES', 'DINNER', 100,
        '<ol>
            <li>Trim and salt the chicken:</li>
            <p>Trim the chicken pieces of excess fat. Pat the chicken pieces dry with a paper towel. Sprinkle all sides with salt. Let the chicken pieces sit for 15 to 20 minutes to take the chill off.</p>
            <li>Preheat the oven to 400°F (205°C)</li>
            <p></p>
            <li>Prep the chicken:</li>
            <p>Pat the chicken pieces dry with a paper towel. Rub olive oil over the chicken pieces and on the bottom of the roasting pan. Sprinkle the chicken pieces all over with black pepper and a little more salt. Arrange the chicken pieces in the pan so that all the pieces are skin-side up, and the largest pieces (the breasts) are in the center of the pan. Dont crowd the pan; allow room in between the pieces.</p>
            <li>Bake the chicken:</li>
            <p>Bake (uncovered) in the oven for 30 minutes at 400°F (205°C). This initial high heat will help brown the chicken. Then lower the heat to 350°F (175°C) and bake for an additional 10-30 minutes until the juices run clear (not pink) when poked with a sharp knife or the internal temperature of the chicken breasts is 165°F (74°C), and of the thighs is 170°F (77°C) when tested with a meat thermometer. If the chicken isnt browning well enough, place the chicken under the broiler for the last 5 minutes of cooking, until browned sufficiently.</p>
            <li>Let it rest:</li>
            <p>Remove from oven and transfer the chicken to a serving dish. Tent with aluminum foil and let rest for 5 to 10 minutes before serving.</p>
            <li>Make gravy:</li>
            <p>If you would like to make gravy with the drippings from the chicken, place the roasting pan with all its drippings on the stovetop and set the burner to medium heat. Use a metal spatula to scrape up the stuck drippings from the bottom of the pan. When the pan is hot, pour in some white wine or chicken stock to help loosen the drippings from the pan. Transfer the drippings and stock/wine mixture to a saucepan and heat on medium high until reduced to your desired thickness. If you want the gravy even thicker, you can make a slurry with a little cornstarch or flour (a teaspoon) and water (1/4 cup), and add that to the gravy while it cooks.</p>
            <li>Serve:</li>
            <p>Serve with steamed rice, mashed potatoes, or Spanish rice.</p>
        </ol>'),
       (8, 'Kentucky Hot Brown', 2, '30 MINUTES', 'DINNER', 90,
        '<ol>
            <li>Preheat the oven, prepare two baking sheets:</li>
            <p>Preheat the oven to 400°F. Line two rimmed baking sheets with heavy duty aluminum foil—one for the bacon and other to assemble the sandwiches, it should be large enough to set two slices of bread side by side.</p>
            <li>Cook the bacon:</li>
            <p>Lay the bacon slices on one of the baking sheets. Cook the bacon, until crispy and to your liking, rotating the pan halfway through cooking if necessary, and checking for doneness at about 12 minutes. Transfer bacon to a paper-towel lined plate to drain excess grease.</p>
            <li>Toast the bread and assemble the sandwiches:</li>
            <p>Toast 4 slices of bread in a toaster, toaster oven, or regular oven. On the remaining baking sheet place two slices of toast side by side in a single layer. Cut the other two slices of toast on a diagonal to form triangles and set those pieces aside. Cut four slices of tomato. Divide the turkey evenly between the slices of toast on the baking sheet. Top each stack of turkey with two slices of tomato. Season with salt and pepper.</p>
            <li>Make the cheese sauce:</li>
            <p>Set a small heavy-bottomed saucepan over medium heat. Add the butter. Once it melts, slowly whisk in the flour and continue to whisk until the mixture turns a shade darker and begins to smell slightly nutty, about 1 minute. This will allow the raw flour taste to cook out. Slowly pour in the milk and cream, whisking constantly, until the mixture is smooth and thick, about 3 minutes. When you first start pouring in the liquid, it will look ugly and grainy. Dont worry! It will calm down, come back together and smooth itself out once all of the liquid is whisked in.</p>
            <li>Remove from heat and add the cheese:</li>
            <p>Remove from heat and add the cheese: Remove the sauce from the heat and whisk in the cheese, salt, pepper, and nutmeg. Whisk to combine until the cheese melts. Taste and adjust seasonings as necessary, keeping in mind the saltiness of your turkey. Spoon half of the sauce over each sandwich.</p>
            <li>Broil the sandwiches:</li>
            <p>Set the oven rack about 5 inches from the broiler element. Preheat the broiler. Broil the sandwiches until the sauce is browned in spots and bubbling, 3 to 5 minutes.</p>
            <li>Serve the sandwiches:</li>
            <p>With a spatula, transfer each sandwich and two triangles of toast to a plate. Spoon the remaining sauce from the baking dish onto the plates. Crisscross 2 slices of bacon over top each sandwich and garnish with parsley. Serve while still hot.</p>
        </ol>'
        ),
       (9, 'Easy Homemade Hummus', 2, '5 MINUTES', 'SNACKS', 77,
        '<ol>
            <li>Process tahini and olive oil:</li>
            <p>In a food processor, combine the tahini and olive oil and pulse until smooth.</p>
            <li>Add remaining ingredients, process until smooth:</li>
            <p>Then add the garlic, garbanzo beans, lemon juice, 1/2 cup water and 1/2 teaspoon of salt. Process until smooth. The longer you process in the food processor, the smoother the hummus will be. Add more salt or lemon juice to taste.</p>
            <li>Serve:</li>
            <p>Spoon into serving dish, swirl a little olive oil over the top and sprinkle with garnishes—a little paprika, toasted pine nuts, or chopped fresh parsley. Serve with crackers, raw dip vegetables such as carrots or celery, or with toasted pita bread. To toast pita bread, cut the pita bread into triangles, brush with olive oil and toast for 10 minutes in a 375°F oven, turning them over half-way through the cooking.</p>
        </ol>'
        ),
       (10, 'Mango Salsa', 1, '10 MINUTES', 'SNACKS', 123,
        '<ol>
            <li>Mix ingredients:</li>
            <p>Put the diced mango, red onion, jalapeño and cilantro in a medium bowl. Toss with lime juice. If the salsa is too acidic for you, stir in some diced avocado.</p>
            <li>Serve:</li>
            <p>Serve with fish, steak, tacos, or tortilla chips!</p>
        </ol>'
        ),
       (11, 'Brownie in a Mug', 1, '5 MINUTES', 'DESSERT', 91,
        '<ol>
            <li>Melt the butter, if using:</li>
            <p>Put the butter in a small microwave-safe bowl or ramekin, and microwave at 50% power (power level 5 on most microwaves) for 30 seconds. If it’s not melted after that, continue to microwave in 10-seconds bursts until it is.</p>
            <li>Combine the dry ingredients in a mug:</li>
            <p>Place the flour, sugar, cocoa, salt (if using unsalted butter), and optional cinnamon in a microwave-safe ceramic mug. Stir with a fork until it resembles brown sand and there are no clumps.</p>
            <li>Add the wet ingredients and stir:</li>
            <p>Stir in the butter (or oil) with a fork until a paste forms. Then add the milk (or water or coffee) and vanilla, and stir with the same fork until smooth. The batter may look a little thin, but don’t worry—that’s how it’s supposed to be.</p>
            <li>Cook in the microwave:</li>
            <p>Microwave, uncovered, on high power for 1 minute. You may need to adjust the time for less or more powerful microwaves. If you don''t know the power level on your microwave, start with 1 minute and continue cooking in 10-second increments until the brownie is done. For a 1000-watt microwave 1 minute is good; for 1650-watt microwaves, we recommend 1 minute and 10 seconds. After cooking, the brownie should still look a tad moist, not dry. Some wet-looking spots are okay; those will set up as the brownie rests.</p>
            <li>Rest 4 minutes:</li>
            <p>Let the brownie rest for 4 minutes. The inside of the brownie is very hot and still cooking, even though it’s not in the microwave. It may be hard, but the wait is worth it! It gives the brownie a better flavor and texture.</p>
            <li>Top with ice cream:</li>
            <p>Serve with a scoop of vanilla ice cream or a small dab of cream (whipped or unwhipped).</p>
        </ol>'
        ),
       (12, 'Rice Pudding', 4, '35 MINUTES', 'DESSERT', 126,
        '<ol>
            <li>Cook the rice in milk</li>
            <p>In a medium-sized, heavy-bottomed saucepan, bring the milk, rice and salt to a boil over high heat. Reduce heat to low and simmer partially covered until the rice is tender, about 20-25 minutes. Stir frequently to prevent the rice from sticking to the bottom of the pan.</p>
            <li>Mix egg and brown sugar, temper with rice mixture:</li>
            <p>In a small mixing bowl, whisk together egg and brown sugar until well mixed. Add a half cup of the hot rice mixture to the egg mixture, a tablespoon at a time, vigorously whisking to incorporate.</p>
            <li>Add tempered egg mixture back to rice mixture:</li>
            <p>Add egg mixture back into the saucepan of rice and milk and stir, on low heat, for 5 to 10 minutes, until thickened, or about 160°F (71°C). Be careful not to have the mixture come to a boil at this point or it will curdle. Remove from heat and stir in the vanilla, raisins, and cinnamon.</p>
            <li>Serve:</li>
            <p>Serve warm or cold</p>
        </ol>'
        );

INSERT INTO ingredient(id, quantity, measurement, name, recipe_id)
VALUES (1, 1, 'TABLESPOON', 'extra-virgin olive oil', 1),
       (2, 1, 'LARGE', 'red onion, thinly sliced, divided', 1),
       (3, 2, 'CLOVE', 'garlic, thinly sliced', 1),
       (4, 1, 'PIECE', 'chipotle chili in adobo sauce', 1),
       (5, 2, 'CAN', 'cans black bean, not drained or 3 1/2 cups cooked beans plus 1 cup bean cooking liquid', 1),
       (6, 1, 'TABLESPOON', 'lime juice', 1),
       (7, 2, 'TEASPOON', 'ground cumin', 1),
       (8, 1, 'TABLESPOON', 'kosher salt', 1),
       (9, 8, 'PIECE', 'corn tortillas', 1),
       (10, 0.5, 'CUP', 'crumbled cotija cheese', 1),
       (11, 0.3, 'CUP', 'Mexican salsa', 1),
       (12, 0.3, 'CUP', 'light or regular sour cream', 1),
       (13, 0.3, 'CUP', 'chopped cilantro', 1),
       (14, 2, 'TABLESPOON', ' olive oil', 2),
       (15, 1, 'TEASPOON', 'smoked paprika', 2),
       (16, 1, 'TEASPOON', 'ground cumin', 2),
       (17, 0.25, 'TEASPOON', 'teaspoon Maras or Aleppo pepper flakes, or 1/8 teaspoon crushed red pepper flakes', 2),
       (18, 1, 'LARGE', 'yellow onion, halved and thinly sliced', 2),
       (19, 2, 'CLOVE', 'garlic, thinly sliced', 2),
       (20, 1, 'PIECE', 'red bell pepper, seeded and thinly sliced', 2),
       (21, 1, 'PIECE', 'yellow bell pepper, seeded and thinly sliced', 2),
       (22, 1, 'CAN', 'whole peeled tomatoes, preferably San Marzano', 2),
       (23, 0.5, 'TEASPOON', 'salt, to taste', 2),
       (24, 4, 'OUNCE', 'feta cheese, crumbled', 2),
       (25, 0.33, 'CUP', 'pitted Kalamata or other olives in brine', 2),
       (26, 1, 'LARGE', 'eggs', 2),
       (27, 6, 'LARGE', 'eggs', 3),
       (28, 0.25, 'CUP', 'milk', 3),
       (29, 2.5, 'TABLESPOON', 'olive oil', 3),
       (30, 0.75, 'TEASPOON', 'ground turmeric', 3),
       (31, 0.5, 'CUP', 'diced red onions', 3),
       (32, 2, 'CLOVE', ' garlic, minced', 3),
       (33, 8, 'OUNCE', 'fingerling potatoes, thinly sliced down their length', 3),
       (34, 1, 'MEDIUM', 'red pepper, seeded and diced', 3),
       (35, 1, 'PIECE', 'scallion, thinly sliced', 3),
       (36, 1, 'CUP', ' baby spinach', 3),
       (37, 1, 'PINCH', 'Freshly ground black pepper', 3),
       (38, 1, 'POUND', 'boneless, skinless (raw) chicken breasts, cut into 2 1/2-inch chunks (or 2 to 3 cups cooked chicken meat)', 4),
       (40, 2, 'STALK', 'celery, chopped', 4),
       (41, 0.5, 'PIECE', 'red bell pepper, seeded and chopped', 4),
       (42, 6, 'PIECE', 'green olives, pitted and minced', 4),
       (43, 0.25, 'CUP', 'chopped red onion', 4),
       (44, 1, 'PIECE', 'apple, cored and chopped', 4),
       (45, 0.5, 'HEAD', 'iceberg head lettuce, sliced and chopped', 4),
       (46, 5, 'TABLESPOON', 'mayonnaise', 4),
       (47, 1, 'TABLESPOON', ' plum preserves, or any sweet berry preserve (or a lesser amount of honey)', 4),
       (48, 1, 'TEASPOON', ' fresh squeezed lemon juice', 4),
       (49, 1, 'PINCH', 'Salt and pepper to taste', 4),
       (50, 2, 'CUP', 'finely diced or ground ham (about 3/4 pound)', 5),
       (51, 3, 'MEDIUM', 'hard-boiled eggs, chopped', 5),
       (52, 0.25, 'CUP', 'sweet pickle relish', 5),
       (53, 0.25, 'CUP', 'mayonnaise', 5),
       (54, 2, 'TABLESPOON', 'minced green onion', 5),
       (55, 2, 'TABLESPOON', 'minced celery', 5),
       (56, 2, 'TABLESPOON', 'minced red bell pepper', 5),
       (57, 1, 'TABLESPOON', 'chopped fresh parsley', 5),
       (58, 1, 'TEASPOON', 'Dijon mustard', 5),
       (59, 1, 'TABLESPOON', 'lemon juice', 5),
       (60, 1, 'PINCH', 'cayenne (optional)', 5),
       (61, 1, 'PINCH', 'Salt and black pepper to taste', 5),
       (62, 1, 'CAN', 'tuna fish', 6),
       (63, 0.3, 'CUP', 'cottage cheese', 6),
       (64, 2, 'TABLESPOON', 'mayonnaise', 6),
       (65, 0.25, 'CUP', 'finely chopped red onion', 6),
       (66, 1, 'STALK', 'celery, finely chopped (about 1/2 cup)', 6),
       (67, 1, 'TABLESPOON', 'capers', 6),
       (68, 1, 'TABLESPOON', 'lemon juice', 6),
       (69, 1, 'PINCH', 'dill', 6),
       (70, 2, 'TABLESPOON', 'minced fresh parsley', 6),
       (71, 1, 'TEASPOON', 'Dijon mustard', 6),
       (72, 2, 'SLICE', 'bread, lightly toasted', 6),
       (73, 1, 'PIECE', '(3 to 4 pound) chicken, cut into 8 parts (2 breasts, 2 thighs, 2 legs, 2 wings), excluding the back', 7),
       (74, 2, 'TABLESPOON', 'Extra virgin olive oil', 7),
       (75, 1, 'PINCH', 'Kosher salt', 7),
       (76, 1, 'PINCH', 'Freshly ground black pepper', 7),
       (77, 0.5, 'CUP', 'low sodium chicken stock (see Recipe Note) or white wine for the gravy (optional)', 7),
       (78, 4, 'SLICE', 'bacon', 8),
       (79, 4, 'SLICE', 'Texas toast or white sandwich bread', 8),
       (80, 10, 'OUNCE', 'deli-sliced roast turkey', 8),
       (81, 1, 'PIECE', 'tomato', 8),
       (82, 0.125, 'TEASPOON', 'kosher salt (optional)', 8),
       (83, 0.125, 'TEASPOON', 'freshly ground black pepper (optional)', 8),
       (84, 0.5, 'TEASPOON', 'chopped fresh parsley, for garnish', 8),
       (85, 2, 'TABLESPOON', 'unsalted butter', 8),
       (86, 2, 'TABLESPOON', 'all-purpose flour', 8),
       (87, 1, 'CUP', 'whole milk, room temperature', 8),
       (88, 0.5, 'CUP', 'heavy cream, room temperature', 8),
       (89, 0.25, 'CUP', '(1 ounce) grated Pecorino Romano', 8),
       (90, 1, 'TEASPOON', 'kosher salt', 8),
       (91, 0.125, 'TEASPOON', 'freshly ground black pepper', 8),
       (92, 0.125, 'TEASPOON', 'ground nutmeg', 8),
       (93, 0.5, 'CUP', ' tahini (roasted, not raw)', 9),
       (94, 0.25, 'CUP', 'extra virgin olive oil (plus more for garnishing)', 9),
       (95, 2, 'CLOVE', 'garlic, mashed and roughly chopped', 9),
       (96, 2, 'CAN', 'chickpeas (garbanzo beans), drained', 9),
       (97, 0.25, 'CUP', 'lemon juice, freshly squeezed', 9),
       (98, 0.5, 'CUP', 'water', 9),
       (99, 0.5, 'TEASPOON', 'salt', 9),
       (100, 1, 'GARNISHES', 'A sprinkling of paprika, a swirl of olive oil, toasted pine nuts, and/or chopped parsley', 9),
       (101, 1, 'PIECE', 'mango, peeled, pitted, and finely diced (about 1 1/2 cup)', 10),
       (102, 1, 'TABLESPOON', 'finely chopped red onion', 10),
       (103, 2, 'PIECE', 'jalapeño chile, minced (less or more to taste, make sure to actually taste the chile first, some of them can be quite hot!)', 10),
       (104, 3, 'TABLESPOON', 'fresh cilantro leaves, chopped', 10),
       (105, 3, 'TABLESPOON', 'fresh lime juice', 10),
       (106, 2, 'TABLESPOON', '(30 ml) butter, mild extra-virgin olive oil, or neutral oil', 11),
       (107, 0.25, 'CUP', '(30 grams) flour', 11),
       (108, 3, 'TABLESPOON', '35 grams) sugar ', 11),
       (109, 2, 'TABLESPOON', '(13 grams) natural unsweetened cocoa powder (NOT Dutch processed)', 11),
       (110, 1, 'PINCH', 'salt', 11),
       (111, 1, 'PINCH', 'cinnamon, optional', 11),
       (112, 3, 'TABLESPOON', '(44 ml) milk, water, or coffee', 11),
       (113, 0.125, 'TEASPOON', 'vanilla extract', 11),
       (114, 1, 'GARNISHES', 'Ice cream, whipped cream, or heavy cream, for serving', 11),
       (115, 2.5, 'CUP', '(600 ml) of whole milk', 12),
       (116, 0.3, 'CUP', '66 grams) of uncooked short grain white rice', 12),
       (117, 1, 'PINCH', 'salt', 12),
       (118, 1, 'PIECE', 'egg', 12),
       (119, 0.25, 'CUP', '(50 grams) dark brown sugar', 12),
       (120, 1, 'TEASPOON', 'vanilla extract', 12),
       (121, 0.25, 'TEASPOON', 'cinnamon', 12),
       (122, 0.3, 'CUP', '(40 grams) raisins', 12);