/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truco.plugin.cardlist.ouro.incomum;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import truco.plugin.cards.Carta;
import truco.plugin.cards.skills.Skill;
import truco.plugin.damage.DamageManager;
import truco.plugin.utils.ChatUtils;
import truco.plugin.utils.LocUtils;
import truco.plugin.utils.TeamUtils;

/**
 *
 * @author Júnior
 */
public class Clarevidencia extends Carta {

    Skill skill = new Skill(this, 8, 30) {

        @Override
        public String getName() {
            return "Limpador de Debuffs";
        }

        @Override
        public boolean onCast(Player p) {
            Player alv;
            if (p.isSneaking()) {
                alv = p;
                ChatUtils.sendMessage(p, "§aVocê se livrou dos debuffs leves.");
            } else {
                Entity alvo = LocUtils.getTarget(p, LocUtils.TargetType.ALIADO);
                if (alvo == null || alvo.getType() != EntityType.PLAYER || alvo.getLocation().distance(p.getLocation()) > 10) {
                    p.sendMessage(ChatColor.RED + "Voce precisa de um alvo !");
                    return false;
                }
                final Player aliado = (Player) alvo;
                if (TeamUtils.canAttack(p, (Player) alvo)) {
                    p.sendMessage(ChatColor.RED + "Voce so pode fazer isto em aliados !");
                    return false;
                }
                ChatUtils.sendMessage(aliado, "§a" + p.getName() + " lhe tirou os debuffs leves");
                alv = aliado;

            }
            DamageManager.removeDebuffsPotions(alv);

            return true;
        }
    };

    @Override
    public Skill getSkill() {
        return skill;
    }

    @Override
    public Raridade getRaridade() {
        return Raridade.INCOMUM;
    }

    @Override
    public String getNome() {
        return "Clarevidencia";
    }

    @Override
    public String[] getDesc() {
        return new String[]{"Remove os debuffs leves de um aliado", "ou se abaixando de você mesmo"};
    }

    @Override
    public Armadura getArmadura() {
        return Armadura.OURO;
    }

}
