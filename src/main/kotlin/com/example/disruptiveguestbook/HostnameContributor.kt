package com.example.disruptiveguestbook

import org.springframework.boot.actuate.info.Info
import org.springframework.boot.actuate.info.InfoContributor
import org.springframework.stereotype.Component
import java.net.InetAddress

@Component
class HostnameContributor : InfoContributor {
    override fun contribute(builder: Info.Builder?) {
        builder?.withDetail("hostname", InetAddress.getLocalHost().getHostName() )?.build()
    }
}
