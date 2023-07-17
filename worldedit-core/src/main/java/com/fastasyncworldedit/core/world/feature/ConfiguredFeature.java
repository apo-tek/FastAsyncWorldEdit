package com.fastasyncworldedit.core.world.feature;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.registry.NamespacedRegistry;

/**
 * Representation for Minecraft internal ConfiguredFeature
 *
 * @param <CF> Server internal ConfiguredFeature
 * @since TODO
 */
public class ConfiguredFeature<CF> implements Feature {

    public static final NamespacedRegistry<ConfiguredFeature<?>> REGISTRY = new NamespacedRegistry<>(
            "configured feature",
            true
    );

    private final CF configuredFeature;
    private final String id;

    /**
     * New instance
     *
     * @since TODO
     */
    public ConfiguredFeature(String id, CF configuredFeature) {
        this.id = id;
        this.configuredFeature = configuredFeature;
    }

    /**
     * Get the minecraft internal ConfiguredFeature
     */
    public CF getConfiguredFeature() {
        return configuredFeature;
    }

    @Override
    public String getId() {
        return id;
    }

    /**
     * Place this feature into an {@link EditSession}
     *
     * @param extent   EditSession to place into
     * @param position position to use for placement
     * @return true if successful
     */
    public boolean place(EditSession extent, BlockVector3 position) {
        return extent.getWorld().placeFeature(this, extent, position);
    }

}
