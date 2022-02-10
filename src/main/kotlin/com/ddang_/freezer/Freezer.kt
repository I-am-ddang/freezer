package com.ddang_.freezer

import com.ddang_.freezer.listeners.BasicListener
import com.ddang_.freezer.objects.Member
import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler

class Freezer : JavaPlugin() {
    companion object {
        lateinit var scheduler: BukkitScheduler
            private set
        lateinit var instance: Plugin
            private set
        lateinit var players: MutableCollection<out Player>
            private set
        lateinit var manager: PluginManager
            private set

        fun Long.rl(run: Runnable) = scheduler.runTaskLater(instance, run, this)
        fun Long.rt(delay: Long = 1, run: Runnable) = scheduler.runTaskTimer(instance, run, delay, this)
        fun String.broad() = Bukkit.broadcastMessage(this)
        fun hex(hex: String): ChatColor = ChatColor.of("#$hex")

        val prefix = "${hex("9fb7d9")}§l  FREEZER ::${hex("d7d8d9")}"
    }

    private fun reloadMember() {
        players.forEach {
            Member(it.name)
        }
    }

    private val events = arrayOf(BasicListener())

    override fun onEnable() {
        players = server.onlinePlayers
        instance = this
        scheduler = server.scheduler
        manager = server.pluginManager

        //이벤트
        server.pluginManager.apply { events.forEach { registerEvents(it, this@Freezer) } }

        //리로드시 멤버 객체 재생성
        reloadMember()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}