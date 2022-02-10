package com.ddang_.freezer.listeners

import com.ddang_.freezer.Freezer
import com.ddang_.freezer.managers.LogManager
import com.ddang_.freezer.managers.MemberManager
import com.ddang_.freezer.objects.Member
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import java.text.SimpleDateFormat
import java.util.*

class BasicListener: Listener {
    @EventHandler
    fun join(e: PlayerJoinEvent) {
        val p = e.player
        Member(p.name)
    }

    @EventHandler
    fun quit(e: PlayerQuitEvent) {
        val p = e.player
        val m = MemberManager.getMember(p.name) ?: return

        val now = Date()
        val format = SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초:SS", Locale.KOREA)

        if (m.status == 1) {
            LogManager.sendMessageToOperator("")
            LogManager.sendMessageToOperator("${Freezer.prefix} ${p.name}이(가) 프리징 상태에서 서버 접속을 종료했습니다.")
            LogManager.sendMessageToOperator("${Freezer.prefix} 접속 종료 시각: ${format.format(now)}")
        }

        MemberManager.memberList.remove(m)
    }
}