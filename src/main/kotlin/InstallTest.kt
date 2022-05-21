package NoMathExpectation.ktorInstallTest

import io.ktor.client.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.resources.*
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info

object InstallTest : KotlinPlugin(
    JvmPluginDescription(
        id = "NoMathExpectation.ktorInstallTest",
        version = "1.0-SNAPSHOT",
    )
) {
    override fun onEnable() {
        CommandManager.registerCommand(object: SimpleCommand(this, "test") {
            @Handler
            fun handle() {
                logger.info {
                    HttpClient(Java) {
                        install(Resources)
                    }.toString()
                }
            }
        })
        logger.info { "Ktor install test loaded." }
    }
}