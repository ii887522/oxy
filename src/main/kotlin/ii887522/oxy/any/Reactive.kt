package ii887522.oxy.any

import ii887522.oxy.collection.ArrayList

/**
 * It is a wrapper over the value so that changes to the value can be notified to all the watchers subscribed to this wrapper. It is used to establish component
 * communications through the value in the wrapper to reduce coupling between components.
 */
class Reactive<T>(initialValue: T) {
  private val onValueChanges = ArrayList<(oldValue: T, newValue: T) -> Unit>()

  var value = initialValue
    set(value) {
      val oldValue = field
      val newValue = value
      field = newValue
      for (onValueChange in onValueChanges) onValueChange(oldValue, newValue)
    }

  /**
   * It registers a handler that processes the changes of the value so that the component which watches this object can be notified.
   *
   * @param onValueChange The handler that processes the changes of the value.
   */
  operator fun plusAssign(onValueChange: (oldValue: T, newValue: T) -> Unit) {
    onValueChanges.append(onValueChange)
  }
}
