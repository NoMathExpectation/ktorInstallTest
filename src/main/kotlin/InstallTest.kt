package NoMathExpectation.ktorInstallTest

import io.ktor.client.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.resources.*
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.MessageEvent
import net.mamoe.mirai.utils.info

object InstallTest : KotlinPlugin(
    JvmPluginDescription(
        id = "NoMathExpectation.ktorInstallTest",
        version = "1.0-SNAPSHOT",
    )
) {
    override fun onEnable() {
        logger.info { "Plugin loaded" }
        GlobalEventChannel.subscribeAlways<MessageEvent> { e ->
            if (e.message.contentToString() == "test") {
                e.subject.sendMessage(HttpClient(Java) {
                    install(Resources)
                }.toString())
            }
        }
    }
}