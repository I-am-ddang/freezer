package com.ddang_.freezer.commands

import com.ddang_.freezer.Freezer
import com.ddang_.freezer.managers.CommandManager
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class MainCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) {
            CommandManager.helpMessage(sender)
            return false
        }

        when (args.size) {
            1 -> {
                when (args[0]) {
                    "help" -> {
                        CommandManager.helpMessage(sender)
                    }
                    "freeze" -> {
                        
                    }
                    else -> {
                        sender.sendMessage("")
                        sender.sendMessage("${Freezer.prefix} 잘못된 명령어 사용입니다. /f help 로 모든 명령어를 확인하세요.")
                    }
                }
            }
            2 -> {

            }
            else -> {
                sender.sendMessage("")
                sender.sendMessage("${Freezer.prefix} 잘못된 명령어 사용입니다. /f help 로 모든 명령어를 확인하세요.")
            }
        }
        return false
    }
}