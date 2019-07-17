package circlet.plugins.pipelines.services.run

import circlet.plugins.pipelines.utils.*
import com.intellij.execution.configurations.*
import com.intellij.openapi.components.*
import com.intellij.openapi.project.*
import com.intellij.openapi.util.*
import runtime.*

class CircletRunConfigurationType : SimpleConfigurationType(
    "CircletRunConfiguration",
    "$ProductName Task", "Run $ProductName Task", NotNullLazyValue.createValue { CircletIcons.mainIcon }) {

    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return CircletRunConfiguration(project, this)
    }

    override fun getOptionsClass(): Class<out BaseState>? {
        return CircletRunTaskConfigurationOptions::class.java
    }
}
