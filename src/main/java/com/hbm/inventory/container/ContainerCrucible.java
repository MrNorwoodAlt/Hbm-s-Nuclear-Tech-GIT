package com.hbm.inventory.container;

import com.hbm.inventory.SlotNonRetarded;
import com.hbm.tileentity.machine.TileEntityCrucible;
import com.hbm.util.InventoryUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCrucible extends Container {

    protected TileEntityCrucible crucible;

    public ContainerCrucible(InventoryPlayer invPlayer, TileEntityCrucible crucible) {
        this.crucible = crucible;

        //template
        this.addSlotToContainer(new SlotNonRetarded(crucible.inventory, 0, 107, 81));

        //input
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.addSlotToContainer(new SlotNonRetarded(crucible.inventory, j + i * 3 + 1, 107 + j * 18, 18 + i * 18));
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 132 + i * 18));
            }
        }

        for(int i = 0; i < 9; i++) {
            this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 190));
        }
    }

    @Override
    public ItemStack slotClick(int index, int button, ClickType clickTypeIn, EntityPlayer player) {
        if(clickTypeIn == ClickType.CLONE) return ItemStack.EMPTY;
        return super.slotClick(index, button, clickTypeIn, player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if(slot != null && slot.getHasStack()) {
            ItemStack originalStack = slot.getStack();
            stack = originalStack.copy();

            if(index <= 9) {
                if(!this.mergeItemStack(originalStack, 10, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(originalStack, stack);

            } else if(!InventoryUtil.mergeItemStack(this.inventorySlots, originalStack, 0, 10, false)) {
                return ItemStack.EMPTY;
            }

            if(originalStack.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return stack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return crucible.isUseableByPlayer(player);
    }
}
