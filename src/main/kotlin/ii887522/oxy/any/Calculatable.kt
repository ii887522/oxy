package ii887522.oxy.any

interface Calculatable<T : Calculatable<T>> {
  operator fun plus(that: T): T
  operator fun minus(that: T): T
  operator fun times(that: T): T
  operator fun div(that: T): T
  operator fun plus(that: Number): T
  operator fun minus(that: Number): T
  operator fun times(that: Number): T
  operator fun div(that: Number): T
}
