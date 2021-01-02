package net.fiftyfivec3.cheats;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.LootJsonParser;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.LootTable;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheatingMod implements ModInitializer {
	private static final Identifier BLAZE = new Identifier("minecraft", "entities/blaze");
	private static final Identifier BARTER = new Identifier("minecraft", "gameplay/piglin_bartering");

	private static final String blaze = "{\"type\":\"minecraft:entity\",\"pools\":[{\"rolls\":1,\"entries\":[{\"type\":\"minecraft:item\",\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"n\":1,\"p\":0.7,\"type\":\"minecraft:binomial\"}}],\"name\":\"minecraft:blaze_rod\"}]}]}";
	private static final String barter = "{\"type\":\"minecraft:barter\",\"pools\":[{\"rolls\":1,\"entries\":[{\"type\":\"minecraft:item\",\"weight\":5,\"functions\":[{\"function\":\"minecraft:enchant_randomly\",\"enchantments\":[\"minecraft:soul_speed\"]}],\"name\":\"minecraft:book\"},{\"type\":\"minecraft:item\",\"weight\":8,\"functions\":[{\"function\":\"minecraft:enchant_randomly\",\"enchantments\":[\"minecraft:soul_speed\"]}],\"name\":\"minecraft:iron_boots\"},{\"type\":\"minecraft:item\",\"weight\":8,\"functions\":[{\"function\":\"minecraft:set_nbt\",\"tag\":\"{Potion:\\\"minecraft:fire_resistance\\\"}\"}],\"name\":\"minecraft:potion\"},{\"type\":\"minecraft:item\",\"weight\":8,\"functions\":[{\"function\":\"minecraft:set_nbt\",\"tag\":\"{Potion:\\\"minecraft:fire_resistance\\\"}\"}],\"name\":\"minecraft:splash_potion\"},{\"type\":\"minecraft:item\",\"weight\":10,\"functions\":[{\"function\":\"minecraft:set_nbt\",\"tag\":\"{Potion:\\\"minecraft:water\\\"}\"}],\"name\":\"minecraft:potion\"},{\"type\":\"minecraft:item\",\"weight\":10,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":10.0,\"max\":36.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:iron_nugget\"},{\"type\":\"minecraft:item\",\"weight\":74,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":2.0,\"max\":4.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:ender_pearl\"},{\"type\":\"minecraft:item\",\"weight\":20,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":3.0,\"max\":9.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:string\"},{\"type\":\"minecraft:item\",\"weight\":20,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":5.0,\"max\":12.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:quartz\"},{\"type\":\"minecraft:item\",\"weight\":40,\"name\":\"minecraft:obsidian\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":1.0,\"max\":3.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:crying_obsidian\"},{\"type\":\"minecraft:item\",\"weight\":40,\"name\":\"minecraft:fire_charge\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":2.0,\"max\":4.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:leather\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":2.0,\"max\":8.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:soul_sand\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":2.0,\"max\":8.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:nether_brick\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":6.0,\"max\":12.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:spectral_arrow\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":8.0,\"max\":16.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:gravel\"},{\"type\":\"minecraft:item\",\"weight\":40,\"functions\":[{\"function\":\"minecraft:set_count\",\"count\":{\"min\":8.0,\"max\":16.0,\"type\":\"minecraft:uniform\"}}],\"name\":\"minecraft:blackstone\"}]}]}";

	private static final Logger LOGGER = LogManager.getLogger("CheatingMod");

	@Override
	public void onInitialize() {
		LOGGER.warn("A mod to change loot tables has been loaded.");
		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
			if (id.equals(BLAZE)) {
				setter.set(createLoot(blaze));
				LOGGER.warn("The blaze table loot table has been overridden.");
			}
			else if (id.equals(BARTER)) {
				setter.set(createLoot(barter));
				LOGGER.warn("The bartering loot table has been overridden.");
			}
		});
	}

	public static LootTable createLoot(String jsonString) {
		return LootJsonParser.read(jsonString, LootTable.class);
	}
}
