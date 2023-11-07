package dev.enjarai.restartdetector.block;

import dev.enjarai.restartdetector.RestartDetector;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import eu.pb4.polymer.core.api.item.PolymerBlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {
    public static final RestartDetectorBlock RESTART_DETECTOR =
            Registry.register(Registries.BLOCK, RestartDetector.id("restart_detector"),
                    new RestartDetectorBlock(FabricBlockSettings.create()
                            .mapColor(MapColor.OAK_TAN)
                            .instrument(Instrument.BASS)
                            .strength(0.2F)
                            .sounds(BlockSoundGroup.WOOD)
                            .burnable()));
    public static final BlockItem RESTART_DETECTOR_ITEM =
            Registry.register(Registries.ITEM, RestartDetector.id("restart_detector"),
                    new PolymerBlockItem(RESTART_DETECTOR, new FabricItemSettings(), Items.DAYLIGHT_DETECTOR));

    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(group -> group.add(RESTART_DETECTOR_ITEM));
    }
}