/*
 * Nao roba não moço eu fiz isso
 * Tem Direitos Autoriais Aqui Cuidado!
 * Espero que os troxas acreditem ops.
 */
package truco.plugin.utils.mobapi.mobs.monsters;

import java.lang.reflect.Field;
import java.util.List;
import net.minecraft.server.v1_8_R2.DamageSource;
import net.minecraft.server.v1_8_R2.EntityBlaze;
import net.minecraft.server.v1_8_R2.EntityMonster;
import net.minecraft.server.v1_8_R2.PathfinderGoalSelector;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R2.CraftWorld;
import static truco.plugin.utils.mobapi.mobs.EntityTypes.getPrivateField;

;

/**
 *
 * @author Carlos André Feldmann Júnior
 */
public class FreezeBlaze extends EntityBlaze {

    public FreezeBlaze(World world) {
        super(((CraftWorld) world).getHandle());
    

        List goalC = (List) getPrivateField("c", EntityMonster.class, this);
        goalC.clear();

        List targetB = (List) getPrivateField("b", PathfinderGoalSelector.class, targetSelector);
        targetB.clear();
        List targetC = (List) getPrivateField("c", PathfinderGoalSelector.class, targetSelector);
        targetC.clear();
        this.fireProof = true;

    }

    @Override
    public void m() {
    }

    @Override
    protected void E() {
    }

    @Override
    public void makeSound(String s, float f, float f1) {
        return;
    }

    @Override
    public void g(double d0, double d1, double d2) {

    }

    @Override
    public boolean damageEntity(DamageSource damagesource, float f) {
        return false;
    }

    @Override
    public void setOnFire(int i) {
        return;
    }

}
