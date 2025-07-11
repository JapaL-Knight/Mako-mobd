package net.mobmako.makomobd.mixin;

import net.mobmako.makomobd.MakoMobd;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void loadItemModel(ModelIdentifier id);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;loadItemModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 1))
    private void onInit(CallbackInfo ci) {

        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(MakoMobd.MOD_ID, "macuahuitl_3d")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(MakoMobd.MOD_ID, "amethyst_macuahuitl_3d_8")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(MakoMobd.MOD_ID, "amethyst_macuahuitl_3d_7")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(MakoMobd.MOD_ID, "amethyst_macuahuitl_3d_6")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(MakoMobd.MOD_ID, "amethyst_macuahuitl_3d_5")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(MakoMobd.MOD_ID, "amethyst_macuahuitl_3d_4")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(MakoMobd.MOD_ID, "amethyst_macuahuitl_3d_3")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(MakoMobd.MOD_ID, "amethyst_macuahuitl_3d_2")));
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(MakoMobd.MOD_ID, "amethyst_macuahuitl_3d_1")));

    }
}