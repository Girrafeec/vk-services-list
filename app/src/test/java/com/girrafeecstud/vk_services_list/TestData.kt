import com.girrafeecstud.vk_services_list.domain.entity.VkService

object TestData {
    val services = listOf<VkService>(
        VkService(
            serviceName = "ВКонтакте",
            serviceDescription = "Самая популярная соцсеть и первое суперприложение в Роcсии",
            serviceIconUrl = "https://mobile-olympiad-trajectory.hb.bizmrg.com/logo-vk.png",
            serviceUrl = "https://vk.com/"
        ),
        VkService(
            serviceName = "Одноклассники",
            serviceDescription = "Первая соцсеть в России, развлекательная платформа с играми, видео и музыкой",
            serviceIconUrl = "https://mobile-olympiad-trajectory.hb.bizmrg.com/logo-ok.png",
            serviceUrl = "https://ok.ru/"
        )
    )
}