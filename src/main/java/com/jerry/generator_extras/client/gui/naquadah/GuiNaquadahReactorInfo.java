package com.jerry.generator_extras.client.gui.naquadah;

import com.jerry.generator_extras.common.content.naquadah.NaquadahReactorMultiblockData;
import com.jerry.generator_extras.common.tile.naquadah.TileEntityNaquadahReactorController;
import mekanism.client.gui.GuiMekanismTile;
import mekanism.client.gui.element.button.MekanismImageButton;
import mekanism.client.gui.element.tab.GuiEnergyTab;
import mekanism.client.gui.element.tab.GuiHeatTab;
import mekanism.common.Mekanism;
import mekanism.common.MekanismLang;
import mekanism.common.inventory.container.tile.EmptyTileContainer;
import mekanism.common.network.to_server.PacketGuiButtonPress;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.UnitDisplayUtils;
import mekanism.common.util.text.EnergyDisplay;
import mekanism.generators.common.GeneratorsLang;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;

public class GuiNaquadahReactorInfo extends GuiMekanismTile<TileEntityNaquadahReactorController, EmptyTileContainer<TileEntityNaquadahReactorController>> {
    protected GuiNaquadahReactorInfo(EmptyTileContainer<TileEntityNaquadahReactorController> container, Inventory inv, Component title) {
        super(container, inv, title);
        titleLabelY = 5;
    }

    @Override
    protected void addGuiElements() {
        super.addGuiElements();
        addRenderableWidget(new MekanismImageButton(this, 6, 6, 14, getButtonLocation("back"),
                () -> Mekanism.packetHandler().sendToServer(new PacketGuiButtonPress(PacketGuiButtonPress.ClickedTileButton.BACK_BUTTON, tile)), getOnHover(MekanismLang.BACK)));
        addRenderableWidget(new GuiEnergyTab(this, () -> {
            NaquadahReactorMultiblockData multiblock = tile.getMultiblock();
            return List.of(MekanismLang.STORING.translate(EnergyDisplay.of(multiblock.energyContainer)),
                    GeneratorsLang.PRODUCING_AMOUNT.translate(EnergyDisplay.of(multiblock.getPassiveGeneration(false, true))));
        }));
        addRenderableWidget(new GuiHeatTab(this, () -> {
            NaquadahReactorMultiblockData multiblock = tile.getMultiblock();
            Component transfer = MekanismUtils.getTemperatureDisplay(multiblock.lastTransferLoss, UnitDisplayUtils.TemperatureUnit.KELVIN, false);
            Component environment = MekanismUtils.getTemperatureDisplay(multiblock.lastEnvironmentLoss, UnitDisplayUtils.TemperatureUnit.KELVIN, false);
            return List.of(MekanismLang.TRANSFERRED_RATE.translate(transfer), MekanismLang.DISSIPATED_RATE.translate(environment));
        }));
    }
}
