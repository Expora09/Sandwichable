package io.github.foundationgames.sandwichable.items;

import io.github.foundationgames.mealapi.api.MealItemRegistry;
import io.github.foundationgames.sandwichable.Sandwichable;
import io.github.foundationgames.sandwichable.blocks.BlocksRegistry;
import io.github.foundationgames.sandwichable.items.spread.SpreadItem;
import io.github.foundationgames.sandwichable.items.SandwichIngredientItem.Flavor;
import io.github.foundationgames.sandwichable.mixin.ComposterHelper;
import io.github.foundationgames.sandwichable.util.Util;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ItemsRegistry {
    public static final FoodComponent BREADSLICE = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.5F).build();
    public static final FoodComponent TOASTEDBREADSLICE = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).build();
    public static final FoodComponent LETTUCEHEAD = (new FoodComponent.Builder()).hunger(5).saturationModifier(0.8F).snack().build();
    public static final FoodComponent LETTUCELEAF = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.3F).snack().build();
    public static final FoodComponent TOMATO_FOOD = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.42F).build();
    public static final FoodComponent TOMATOSLICE = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.7F).snack().build();
    public static final FoodComponent COOKEDTOMATOSLICE = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.7F).snack().build();
    public static final FoodComponent CUCUMBER_FOOD = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).build();
    public static final FoodComponent PICKLEDCUCUMBER = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.6F).build();
    public static final FoodComponent PICKLECHIPS = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.5F).snack().build();
    public static final FoodComponent ONION_FOOD = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.8F).build();
    public static final FoodComponent CHOPPEDONION = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.6F).snack().build();
    public static final FoodComponent COOKEDCHOPPEDONION = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).snack().build();
    public static final FoodComponent BACON = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.7F).meat().build();
    public static final FoodComponent PORKCUTS = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.3F).meat().build();
    public static final FoodComponent COOKEDPORKCUTS = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.6F).meat().build();
    public static final FoodComponent RAWCHICKFILET = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.2F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 300, 0), 0.3F).meat().build();
    public static final FoodComponent COOKEDCHICKFILET = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.5F).meat().build();
    public static final FoodComponent RAWCODFILET = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.2F).build();
    public static final FoodComponent COOKEDCODFILET = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.5F).build();
    public static final FoodComponent RAWSALMONFILET = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.35F).build();
    public static final FoodComponent COOKEDSALMONFILET = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.8F).build();
    public static final FoodComponent CRIMSONFUNGUS = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.5F).build();
    public static final FoodComponent SLICEDCRIMSONFUNGUS = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.6F).snack().build();
    public static final FoodComponent WARPEDFUNGUS = (new FoodComponent.Builder()).hunger(5).saturationModifier(0.4F).build();
    public static final FoodComponent SLICEDWARPEDFUNGUS = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.5F).snack().build();
    public static final FoodComponent CHOPPEDCARROT = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.5F).snack().build();
    public static final FoodComponent COOKEDCHOPPEDCARROT = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).snack().build();
    public static final FoodComponent CHOPPEDGOLDCARROT = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.8F).snack().build();
    public static final FoodComponent CHOPPEDBEETROOT = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.6F).snack().build();
    public static final FoodComponent COOKEDCHOPPEDBEETROOT = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.7F).snack().build();
    public static final FoodComponent SWEETBERRYJAM = (new FoodComponent.Builder()).hunger(5).saturationModifier(0.5F).build();
    public static final FoodComponent MAYONNAISE_FOOD = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.6F).build();
    public static final FoodComponent APPLESLICES = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.5F).snack().build();
    public static final FoodComponent GOLDAPPLESLICES = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.7F).snack().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 50, 1), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 0), 1.0F).alwaysEdible().build();
    public static final FoodComponent ENCHANTEDGOLDAPPLESLICES = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.8F).snack().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3000, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 3000, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 3), 1.0F).alwaysEdible().build();
    public static final FoodComponent BURNTFOOD = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.1F).build();

    public static final Item BREAD_SLICE = new SandwichIngredientItem(Flavor.BREAD, BREADSLICE, 2, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item TOASTED_BREAD_SLICE = new SandwichIngredientItem(Flavor.BREAD, TOASTEDBREADSLICE, 3, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item LETTUCE_HEAD = new InfoTooltipItem(new Item.Settings().food(LETTUCEHEAD).group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item LETTUCE_LEAF = new SandwichIngredientItem(Flavor.VEGETABLE, LETTUCELEAF, 2, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item CHEESE_WHEEL_REGULAR = new CheeseItem(CheeseType.REGULAR, false);
    public static final Item CHEESE_SLICE_REGULAR = new CheeseItem(CheeseType.REGULAR, true);
    public static final Item CHEESE_WHEEL_CREAMY = new CheeseItem(CheeseType.CREAMY, false);
    public static final Item CHEESE_SLICE_CREAMY = new CheeseItem(CheeseType.CREAMY, true);
    public static final Item CHEESE_WHEEL_INTOXICATING = new CheeseItem(CheeseType.INTOXICATING, false);
    public static final Item CHEESE_SLICE_INTOXICATING = new CheeseItem(CheeseType.INTOXICATING, true);
    public static final Item CHEESE_WHEEL_SOUR = new CheeseItem(CheeseType.SOUR, false);
    public static final Item CHEESE_SLICE_SOUR = new CheeseItem(CheeseType.SOUR, true);
    public static final Item CHEESE_WHEEL_CANDESCENT = new CheeseItem(CheeseType.CANDESCENT, false);
    public static final Item CHEESE_SLICE_CANDESCENT = new CheeseItem(CheeseType.CANDESCENT, true);
    public static final Item CHEESE_WHEEL_WARPED_BLEU = new CheeseItem(CheeseType.WARPED_BLEU, false);
    public static final Item CHEESE_SLICE_WARPED_BLEU = new CheeseItem(CheeseType.WARPED_BLEU, true);
    public static final Item CHEESE_CULTURE_REGULAR = new CheeseCultureItem(CheeseType.REGULAR, new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS).recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item CHEESE_CULTURE_CREAMY = new CheeseCultureItem(CheeseType.CREAMY, new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS).recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item CHEESE_CULTURE_INTOXICATING = new CheeseCultureItem(CheeseType.INTOXICATING, new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS).recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item CHEESE_CULTURE_SOUR = new CheeseCultureItem(CheeseType.SOUR, new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS).recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item CHEESE_CULTURE_CANDESCENT = new CheeseCultureItem(CheeseType.CANDESCENT, new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS).recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item CHEESE_CULTURE_WARPED_BLEU = new CheeseCultureItem(CheeseType.WARPED_BLEU, new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS).recipeRemainder(Items.GLASS_BOTTLE));
    public static final Item TOMATO = new InfoTooltipItem(new Item.Settings().food(TOMATO_FOOD).group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item TOMATO_SLICE = new SandwichIngredientItem(Flavor.VEGETABLE, TOMATOSLICE, 2, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item COOKED_TOMATO_SLICE = new SandwichIngredientItem(Flavor.VEGETABLE, COOKEDTOMATOSLICE, 3, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item CUCUMBER = new InfoTooltipItem(new Item.Settings().food(CUCUMBER_FOOD).group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item PICKLED_CUCUMBER = new InfoTooltipItem(new Item.Settings().food(PICKLEDCUCUMBER).group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item PICKLE_CHIPS = new SandwichIngredientItem(Flavor.VEGETABLE, PICKLECHIPS, 4, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item SALT_ROCK = new InfoTooltipItem(new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item SALT = new InfoTooltipItem(new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item ONION = new InfoTooltipItem(new Item.Settings().food(ONION_FOOD).group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item CHOPPED_ONION = new SandwichIngredientItem(Flavor.SOUR, CHOPPEDONION, 2, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item COOKED_CHOPPED_ONION = new SandwichIngredientItem(Flavor.SOUR, COOKEDCHOPPEDONION, 3, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item CHOPPED_CARROT = new SandwichIngredientItem(Flavor.VEGETABLE, CHOPPEDCARROT, 1, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item COOKED_CHOPPED_CARROT = new SandwichIngredientItem(Flavor.VEGETABLE, COOKEDCHOPPEDCARROT, 2, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item CHOPPED_GOLDEN_CARROT = new SandwichIngredientItem(Flavor.VEGETABLE, CHOPPEDGOLDCARROT, 3, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item CHOPPED_BEETROOT = new SandwichIngredientItem(Flavor.VEGETABLE, CHOPPEDBEETROOT, 2, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item COOKED_CHOPPED_BEETROOT = new SandwichIngredientItem(Flavor.VEGETABLE, COOKEDCHOPPEDBEETROOT, 3, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item SWEET_BERRY_JAM = new BottledFoodItem(true, new Item.Settings().food(SWEETBERRYJAM).maxCount(16).group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item MAYONNAISE = new BottledFoodItem(true, new Item.Settings().food(MAYONNAISE_FOOD).maxCount(16).group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item APPLE_SLICES = new SandwichIngredientItem(Flavor.SWEET, APPLESLICES, 1, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item GOLDEN_APPLE_SLICES = new SandwichIngredientItem(false, Rarity.RARE, Flavor.SWEET, GOLDAPPLESLICES, 2, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item ENCHANTED_GOLDEN_APPLE_SLICES = new SandwichIngredientItem(true, Rarity.EPIC, Flavor.SWEET, ENCHANTEDGOLDAPPLESLICES, 3, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item TOASTED_CRIMSON_FUNGUS = new InfoTooltipItem(new Item.Settings().food(CRIMSONFUNGUS).group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item TOASTED_WARPED_FUNGUS = new InfoTooltipItem(new Item.Settings().food(WARPEDFUNGUS).group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item SLICED_TOASTED_CRIMSON_FUNGUS = new SandwichIngredientItem(Flavor.SOUR, SLICEDCRIMSONFUNGUS, 4, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item SLICED_TOASTED_WARPED_FUNGUS = new SandwichIngredientItem(Flavor.SOUR, SLICEDWARPEDFUNGUS, 4, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item PORK_CUTS = new SandwichIngredientItem(Flavor.MEAT, PORKCUTS, 1, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item COOKED_PORK_CUTS = new SandwichIngredientItem(Flavor.MEAT, COOKEDPORKCUTS, 2, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item BACON_STRIPS = new SandwichIngredientItem(Flavor.MEAT, BACON, 3, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item RAW_CHICKEN_FILET = new SandwichIngredientItem(Flavor.MEAT, RAWCHICKFILET, 1, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item COOKED_CHICKEN_FILET = new SandwichIngredientItem(Flavor.MEAT, COOKEDCHICKFILET, 3, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item RAW_COD_FILET = new SandwichIngredientItem(Flavor.MEAT, RAWCODFILET, 1, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item COOKED_COD_FILET = new SandwichIngredientItem(Flavor.MEAT, COOKEDCODFILET, 2, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item RAW_SALMON_FILET = new SandwichIngredientItem(Flavor.MEAT, RAWSALMONFILET, 1, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item COOKED_SALMON_FILET = new SandwichIngredientItem(Flavor.MEAT, COOKEDSALMONFILET, 2, Sandwichable.SANDWICHABLE_ITEMS);
    public static final Item BURNT_FOOD = new InfoTooltipItem(new Item.Settings().food(BURNTFOOD).group(Sandwichable.SANDWICHABLE_ITEMS));

    public static final Item KITCHEN_KNIFE = new InfoTooltipItem(new Item.Settings().maxCount(1).group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item FERMENTING_MILK_BUCKET = new FermentingMilkBucketItem(new Item.Settings().maxCount(1).group(Sandwichable.SANDWICHABLE_ITEMS));

    public static final Item LETTUCE_SEEDS = new InfoTooltipAliasedBlockItem(BlocksRegistry.LETTUCE, new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item TOMATO_SEEDS = new InfoTooltipAliasedBlockItem(BlocksRegistry.TOMATOES, new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item CUCUMBER_SEEDS = new InfoTooltipAliasedBlockItem(BlocksRegistry.CUCUMBERS, new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item ONION_SEEDS = new InfoTooltipAliasedBlockItem(BlocksRegistry.ONIONS, new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS));

    public static final Item EMPTY_PICKLE_JAR = new PickleJarBlockItem("pickle_jar.content.air", true, new Item.Settings().group(Sandwichable.SANDWICHABLE_ITEMS));
    public static final Item WATER_FILLED_PICKLE_JAR = new PickleJarBlockItem("pickle_jar.content.water", false, new Item.Settings().maxCount(1));
    public static final Item CUCUMBER_FILLED_PICKLE_JAR = new PickleJarBlockItem("pickle_jar.content.water", false, new Item.Settings().maxCount(1));
    public static final Item PICKLING_PICKLE_JAR = new PickleJarBlockItem("pickle_jar.content.brine", false, new Item.Settings().maxCount(1));
    public static final Item PICKLE_FILLED_PICKLE_JAR = new PickleJarBlockItem("pickle_jar.content.brine", false, new Item.Settings().maxCount(1));

    public static final Item SPREAD = new SpreadItem();

    public static void init() {
        registerItem(KITCHEN_KNIFE, "kitchen_knife");
        registerItem(BREAD_SLICE, "bread_slice");
        registerItem(TOASTED_BREAD_SLICE, "toasted_bread_slice");
        registerItem(LETTUCE_HEAD, "lettuce_head");
        ComposterHelper.registerCompostable(0.65f, LETTUCE_HEAD);
        registerItem(LETTUCE_LEAF, "lettuce_leaf");
        ComposterHelper.registerCompostable(0.3f, LETTUCE_LEAF);
        registerItem(TOMATO, "tomato");
        ComposterHelper.registerCompostable(0.65f, TOMATO);
        registerItem(TOMATO_SLICE, "tomato_slice");
        ComposterHelper.registerCompostable(0.3f, TOMATO_SLICE);
        registerItem(COOKED_TOMATO_SLICE, "cooked_tomato_slice");
        registerItem(CUCUMBER, "cucumber");
        ComposterHelper.registerCompostable(0.65f, CUCUMBER);
        registerItem(PICKLED_CUCUMBER, "pickled_cucumber");
        registerItem(PICKLE_CHIPS, "pickle_chips");
        registerItem(SALT_ROCK, "salt_rock");
        registerItem(SALT, "salt");
        registerItem(WATER_FILLED_PICKLE_JAR, "water_filled_pickle_jar");
        registerItem(CUCUMBER_FILLED_PICKLE_JAR, "cucumber_filled_pickle_jar");
        registerItem(PICKLING_PICKLE_JAR, "pickling_pickle_jar");
        registerItem(PICKLE_FILLED_PICKLE_JAR, "pickle_filled_pickle_jar");
        registerItem(EMPTY_PICKLE_JAR, "empty_pickle_jar");
        registerItem(ONION, "onion");
        ComposterHelper.registerCompostable(0.5f, ONION);
        registerItem(CHOPPED_ONION, "chopped_onion");
        ComposterHelper.registerCompostable(0.3f, CHOPPED_ONION);
        registerItem(COOKED_CHOPPED_ONION, "cooked_chopped_onion");
        registerItem(CHOPPED_CARROT, "chopped_carrot");
        ComposterHelper.registerCompostable(0.3f, CHOPPED_CARROT);
        registerItem(COOKED_CHOPPED_CARROT, "cooked_chopped_carrot");
        registerItem(CHOPPED_GOLDEN_CARROT, "chopped_golden_carrot");
        registerItem(CHOPPED_BEETROOT, "chopped_beetroot");
        ComposterHelper.registerCompostable(0.3f, CHOPPED_BEETROOT);
        registerItem(COOKED_CHOPPED_BEETROOT, "cooked_chopped_beetroot");
        registerItem(SWEET_BERRY_JAM, "sweet_berry_jam_bottle");
        registerItem(MAYONNAISE, "mayonnaise_bottle");
        registerItem(APPLE_SLICES, "apple_slices");
        ComposterHelper.registerCompostable(0.3f, APPLE_SLICES);
        registerItem(GOLDEN_APPLE_SLICES, "golden_apple_slices");
        registerItem(ENCHANTED_GOLDEN_APPLE_SLICES, "enchanted_golden_apple_slices");
        registerItem(CHEESE_CULTURE_REGULAR, "regular_cheese_culture_bottle");
        registerItem(CHEESE_CULTURE_CREAMY, "creamy_cheese_culture_bottle");
        registerItem(CHEESE_CULTURE_INTOXICATING, "intoxicating_cheese_culture_bottle");
        registerItem(CHEESE_CULTURE_SOUR, "sour_cheese_culture_bottle");
        registerItem(CHEESE_CULTURE_CANDESCENT, "candescent_cheese_culture_bottle");
        registerItem(CHEESE_CULTURE_WARPED_BLEU, "warped_bleu_cheese_culture_bottle");
        registerItem(CHEESE_WHEEL_REGULAR, "cheese_wheel");
        registerItem(CHEESE_SLICE_REGULAR, "cheese_slice");
        registerItem(CHEESE_WHEEL_CREAMY, "creamy_cheese_wheel");
        registerItem(CHEESE_SLICE_CREAMY, "creamy_cheese_slice");
        registerItem(CHEESE_WHEEL_INTOXICATING, "intoxicating_cheese_wheel");
        registerItem(CHEESE_SLICE_INTOXICATING, "intoxicating_cheese_slice");
        registerItem(CHEESE_WHEEL_SOUR, "sour_cheese_wheel");
        registerItem(CHEESE_SLICE_SOUR, "sour_cheese_slice");
        registerItem(CHEESE_WHEEL_CANDESCENT, "candescent_cheese_wheel");
        registerItem(CHEESE_SLICE_CANDESCENT, "candescent_cheese_slice");
        registerItem(CHEESE_WHEEL_WARPED_BLEU, "warped_bleu_cheese_wheel");
        registerItem(CHEESE_SLICE_WARPED_BLEU, "warped_bleu_cheese_slice");
        registerItem(PORK_CUTS, "pork_cuts");
        registerItem(COOKED_PORK_CUTS, "cooked_pork_cuts");
        registerItem(BACON_STRIPS, "bacon_strips");
        registerItem(RAW_CHICKEN_FILET, "chicken_filet");
        registerItem(COOKED_CHICKEN_FILET, "cooked_chicken_filet");
        registerItem(RAW_COD_FILET, "cod_filet");
        registerItem(COOKED_COD_FILET, "cooked_cod_filet");
        registerItem(RAW_SALMON_FILET, "salmon_filet");
        registerItem(COOKED_SALMON_FILET, "cooked_salmon_filet");
        registerItem(TOASTED_CRIMSON_FUNGUS, "toasted_crimson_fungus");
        registerItem(TOASTED_WARPED_FUNGUS, "toasted_warped_fungus");
        registerItem(SLICED_TOASTED_CRIMSON_FUNGUS, "sliced_toasted_crimson_fungus");
        registerItem(SLICED_TOASTED_WARPED_FUNGUS, "sliced_toasted_warped_fungus");
        registerItem(LETTUCE_SEEDS, "lettuce_seeds");
        ComposterHelper.registerCompostable(0.3f, LETTUCE_SEEDS);
        registerItem(TOMATO_SEEDS, "tomato_seeds");
        ComposterHelper.registerCompostable(0.3f, TOMATO_SEEDS);
        registerItem(CUCUMBER_SEEDS, "cucumber_seeds");
        ComposterHelper.registerCompostable(0.3f, CUCUMBER_SEEDS);
        registerItem(ONION_SEEDS, "onion_seeds");
        ComposterHelper.registerCompostable(0.3f, ONION_SEEDS);
        registerItem(BURNT_FOOD, "burnt_food");
        registerItem(FERMENTING_MILK_BUCKET, "fermenting_milk_bucket");
        registerItem(SPREAD, "spread");

        MealItemRegistry.register(BlocksRegistry.SANDWICH.asItem(), ItemsRegistry::calculateSandwichFullness);
    }

    private static int calculateSandwichFullness(PlayerEntity player, ItemStack stack) {
        int mh = 20 - player.getHungerManager().getFoodLevel();
        float ms = 20.0f - player.getHungerManager().getSaturationLevel();
        int hl = 0;
        for(ItemStack item : ((SandwichBlockItem)BlocksRegistry.SANDWICH.asItem()).getFoodList(stack)) {
            if(item.isFood()) {
                int h = item.getItem().getFoodComponent().getHunger();
                hl += (h + ((float)h * item.getItem().getFoodComponent().getSaturationModifier() * 2.0F));
            }
        }
        hl -= (mh + ms);
        hl *= 1.25;
        return hl;
    }

    private static void registerItem(Item item, String name) {
        Registry.register(Registry.ITEM, Util.id(name), item);
    }
}
