package kev.njunge.androidofflinecache.data

data class University(
    val name:String,
    val country:String,
    val web_pages:Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as University

        if (name != other.name) return false
        if (country != other.country) return false
        if (!web_pages.contentEquals(other.web_pages)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + country.hashCode()
        result = 31 * result + web_pages.contentHashCode()
        return result
    }
}