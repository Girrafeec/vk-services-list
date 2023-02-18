package com.girrafeecstud.vk_services_list.base

interface Mapper<in I, out O> {
    fun map(input: I): O
}