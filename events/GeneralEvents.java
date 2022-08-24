package killerceepr.tutorial.events;

import killerceepr.tutorial.menus.CustomGrindstone;
import killerceepr.tutorial.menus.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class GeneralEvents implements Listener {
    @EventHandler
    private void swapHands(PlayerSwapHandItemsEvent event){
        new CustomGrindstone().open(event.getPlayer());
    }

    @EventHandler
    private void inventoryDrag(InventoryDragEvent event){
        Player p = (Player) event.getWhoClicked();
        Menu menu = Menu.getMenu(p);
        if(menu != null){
            event.setCancelled(true);
            if(menu.getGeneralDragAction() != null) menu.getGeneralDragAction().drag(p, event);
        }
    }

    @EventHandler
    private void inventoryClick(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        Menu menu = Menu.getMenu(p);
        if(menu != null){
            event.setCancelled(true);
            if(event.getClickedInventory() != null){
                //Click in our own inventory.
                if(event.getRawSlot() >= p.getOpenInventory().getTopInventory().getSize()){
                    if(menu.getGeneralInvClickAction() != null) menu.getGeneralInvClickAction().click(p, event);
                }else if(menu.getGeneralClickAction() != null){ //Click in the open menu.
                    menu.getGeneralClickAction().click(p, event);
                }
            }

            Menu.MenuClick menuClick = menu.getAction(event.getRawSlot());
            if(menuClick != null) menuClick.click(p, event);
        }
    }

    @EventHandler
    private void inventoryClose(InventoryCloseEvent event){
        Player p = (Player) event.getPlayer();
        Menu menu = Menu.getMenu(p);
        if(menu != null) menu.remove();
    }



















}
