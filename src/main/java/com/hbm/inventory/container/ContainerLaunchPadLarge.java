package com.hbm.inventory.container;

import api.hbm.energymk2.IBatteryItem;
import api.hbm.item.IDesignatorItem;
import com.hbm.inventory.FluidContainerRegistry;
import com.hbm.inventory.SlotMachineOutput;
import com.hbm.items.ModItems;
import com.hbm.tileentity.bomb.TileEntityLaunchPadBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerLaunchPadLarge extends Container {
	
	private TileEntityLaunchPadBase launchpad;
	
	public ContainerLaunchPadLarge(InventoryPlayer invPlayer, TileEntityLaunchPadBase tedf) {
		
		launchpad = tedf;
		
		//Missile
		this.addSlotToContainer(new SlotItemHandler(tedf.inventory, 0, 26, 36));
		//Designator
		this.addSlotToContainer(new SlotItemHandler(tedf.inventory, 1, 26, 72));
		//Battery
		this.addSlotToContainer(new SlotItemHandler(tedf.inventory, 2, 107, 90));
		//Fuel in
		this.addSlotToContainer(new SlotItemHandler(tedf.inventory, 3, 125, 90));
		//Fuel out
		this.addSlotToContainer(new SlotMachineOutput(tedf.inventory, 4, 125, 108));
		//Oxidizer in
		this.addSlotToContainer(new SlotItemHandler(tedf.inventory, 5, 143, 90));
		//Oxidizer out
		this.addSlotToContainer(new SlotMachineOutput(tedf.inventory, 6, 143, 108));
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 154 + i * 18));
			}
		}

		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 212));
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
		ItemStack var3 = ItemStack.EMPTY;
		Slot var4 = (Slot) this.inventorySlots.get(par2);

		if(var4 != null && var4.getHasStack()) {
			ItemStack var5 = var4.getStack();
			var3 = var5.copy();

			if(par2 <= 6) {
				if(!this.mergeItemStack(var5, 7, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else {
				
				if(var3.getItem() instanceof IBatteryItem || var3.getItem() == ModItems.battery_creative) {
					if(!this.mergeItemStack(var5, 2, 3, false)) {
						return ItemStack.EMPTY;
					}
				} else if(launchpad.isMissileValid(var3)) {
					if(!this.mergeItemStack(var5, 0, 1, false)) {
						return ItemStack.EMPTY;
					}
				} else if(var3.getItem() == ModItems.fluid_barrel_infinite) {
					if(!this.mergeItemStack(var5, 3, 4, false)) if(!this.mergeItemStack(var5, 5, 6, false)) {
						return ItemStack.EMPTY;
					}
				} else if(FluidContainerRegistry.getFluidContent(var3, launchpad.tanks[0].getTankType()) > 0) {
					if(!this.mergeItemStack(var5, 3, 4, false)) {
						return ItemStack.EMPTY;
					}
				} else if(FluidContainerRegistry.getFluidContent(var3, launchpad.tanks[1].getTankType()) > 0) {
					if(!this.mergeItemStack(var5, 5, 6, false)) {
						return ItemStack.EMPTY;
					}
				} else if(var3.getItem() instanceof IDesignatorItem) {
					if(!this.mergeItemStack(var5, 1, 2, false)) {
						return ItemStack.EMPTY;
					}
				} else {
					return ItemStack.EMPTY;
				}
			}

			if(var5.getCount() == 0) {
				var4.putStack(ItemStack.EMPTY);
			} else {
				var4.onSlotChanged();
			}
		}

		return var3;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return launchpad.isUseableByPlayer(player);
	}
}
