package com.ddang_.freezer.objects

import com.ddang_.freezer.managers.MemberManager

class Member (val name: String, var status: Int = 0) {
    init {
        MemberManager.memberList.add(this)
    }
}