import java.util.Stack

//Магазин патронов
class Stack<T> : Stack<T>() {

    override fun push(item: T): T {
        return super.push(item)
    }

    //Получение патрона для выстрела
    override fun pop(): T? = if (isEmpty()) null else super.pop()

    //Проверка наличия патронов в магазине
    override fun isEmpty(): Boolean = super.empty()
}

