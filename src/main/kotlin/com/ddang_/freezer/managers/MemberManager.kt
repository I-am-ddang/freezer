package com.ddang_.freezer.managers

import com.ddang_.freezer.objects.Member

class MemberManager {
    companion object {
        val memberList = arrayListOf<Member>()
        fun getMember(name: String) = memberList.find { it.name == name }
    }
}