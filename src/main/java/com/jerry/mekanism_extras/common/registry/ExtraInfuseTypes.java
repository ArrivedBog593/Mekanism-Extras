package com.jerry.mekanism_extras.common.registry;

import com.jerry.mekanism_extras.MekanismExtras;
import mekanism.api.chemical.infuse.InfuseType;
import mekanism.common.registration.impl.InfuseTypeDeferredRegister;
import mekanism.common.registration.impl.InfuseTypeRegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ExtraInfuseTypes {
    private ExtraInfuseTypes() {

    }

    public static final InfuseTypeDeferredRegister EXTRA_INFUSE_TYPES = new InfuseTypeDeferredRegister(MekanismExtras.MODID);
    public static final InfuseTypeRegistryObject<InfuseType> RADIANCE = EXTRA_INFUSE_TYPES.register("radiance", 0xC4C604);
    public static final InfuseTypeRegistryObject<InfuseType> THERMONUCLEAR = EXTRA_INFUSE_TYPES.register("thermonuclear", 0x810C0C);
    public static final InfuseTypeRegistryObject<InfuseType> SHINING = EXTRA_INFUSE_TYPES.register("shining", MekanismExtras.rl("infuse_type/shining"), 0xFAD1FE);
    public static final InfuseTypeRegistryObject<InfuseType> SPECTRUM = EXTRA_INFUSE_TYPES.register("spectrum", MekanismExtras.rl("infuse_type/spectrum"), 0xBF3314);
    public static final InfuseTypeRegistryObject<InfuseType> LEAD = EXTRA_INFUSE_TYPES.register("lead",0x627370);

    public static void register(IEventBus eventBus) {
        EXTRA_INFUSE_TYPES.register(eventBus);
    }
}
