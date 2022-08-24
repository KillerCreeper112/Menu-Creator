package killerceepr.tutorial.utility;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemCreator {
    public static ItemStack create(Material mat){ return new ItemStack(mat); }
    public static ItemStack create(Material mat, Component name){
        ItemStack item = create(mat);
        ItemMeta meta = item.getItemMeta();
        if(meta == null) return item;
        meta.displayName(name);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack create(Material mat, Component name, List<Component> lore){
        ItemStack item = create(mat, name);
        ItemMeta meta = item.getItemMeta();
        if(meta == null) return item;
        meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack create(Material mat, Component name, List<Component> lore, boolean hideFlags){
        ItemStack item = create(mat, name, lore);
        ItemMeta meta = item.getItemMeta();
        if(meta == null) return item;
        if(hideFlags) meta.addItemFlags(ItemFlag.values());
        else meta.removeItemFlags(ItemFlag.values());
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack create(Material mat, Component name, List<Component> lore, boolean hideFlags, boolean isGlowing){
        ItemStack item = create(mat, name, lore, hideFlags);
        ItemMeta meta = item.getItemMeta();
        if(meta == null) return item;
        if(isGlowing){
            item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        return item;
    }
}
