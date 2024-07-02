
1. <code>import java.util.*;<br>
import Family_tree.Model.Humans.Human;<br>
Owner<br>
@Liberate520 Liberate520 4 days ago<br>
Нехорошо, что View знает об объекте модели
</code>

Исправлено

2. <code>@Liberate520 Liberate520 4 days ago<br>
И в текущем классе и в классе менеджера есть доступ к презентеру. Кто то нарушает иерархию классов и первый принцип солид</code>

Исправлено, Presenter отдал менеджеру, как части View. То есть View делает менеджера, а   менеджер создаёт Презентер.

3. <code> @Liberate520 Liberate520 4 days ago<br>
Презентер взаимодействует с Сервисом, а уже Сервис может взаимодействовать с разными составляющими модели.</code>

Исправлено
