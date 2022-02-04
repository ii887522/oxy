package ii887522.oxy.struct

data class Holder<T>(var value: T) {
  override fun hashCode(): Int {
    return value?.hashCode() ?: 0
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Holder<*>
    if (value is Array<*> && other.value is Array<*>) {
      if (!(value as Array<*>).contentDeepEquals(other.value as Array<*>)) {
        return false
      }
    } else if (value != other.value) return false

    return true
  }
}
