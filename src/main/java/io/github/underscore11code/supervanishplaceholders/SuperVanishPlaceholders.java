package io.github.underscore11code.supervanishplaceholders;

import de.myzelyam.api.vanish.VanishAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
public class SuperVanishPlaceholders extends PlaceholderExpansion {
    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin(getRequiredPlugin()) != null;
    }

    @Override
    public String getIdentifier() {
        return "bettersupervanish";
    }

    @Override
    public String getAuthor() {
        return "Underscore11";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getRequiredPlugin() {
        return "SuperVanish";
    }

    @Override
    public String onPlaceholderRequest(Player p, String params) {
        List<UUID> vanishedList = VanishAPI.getInvisiblePlayers();


        if (params.equalsIgnoreCase("vanishcount")) {
            return String.valueOf(vanishedList.size());
        }

        if (params.equalsIgnoreCase("onlinecount")) {
            return String.valueOf(Bukkit.getOnlinePlayers().size() - vanishedList.size());
        }

        if (p == null) return null;

        if (params.equalsIgnoreCase("vanishstate")) {
            if (vanishedList.contains(p.getUniqueId())) return "&b[V]";
            else return "";
        }

        if (params.equalsIgnoreCase("vanishstatelong")) {
            if (vanishedList.contains(p.getUniqueId())) return "&b[Vanished]";
            else return "";
        }
        return null;
    }
}
