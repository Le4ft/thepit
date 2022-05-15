package com.alpha.redux.questMaster.bossBattles;

import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;

public class BossMalding {

    NPC boss;
    Player target;

    public BossMalding(NPC boss, Player target) {
        this.boss = boss;
        this.target = target;

    }

    public void switchTarget(){
        this.boss = null;
        this.target = null;
    }

    public void switchTarget(Player player){
        this.target = player;
    }

    public NPC getBoss(){
        return this.boss;
    }

}
