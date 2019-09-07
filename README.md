# Android Development Guideline
** 智慧党建项目** Android 开发准则

## 总览

### 设计
- 使用 蓝湖 来查阅设计稿、下载切图
- 各种资源（文本、图片、Dimen）尽量放到 Values Xml 中
- 尽量不要硬编码字符串

### 开发
- 多写注释（行内注释，函数注释以及类注释等）
- 善用 `TODO`，`FIXME` 进行标注
- 网络请求接口尽量用 JUnit 写简单的 Unit Test
- 异步操作统一用 Rx，除非必要，不要使用 Thread 或者 AsyncTask 等其他工具
- 所有调试用的 Log 请用使用 Debug Flag

### Git 协同
- 不要轻易 Push 代码到主 Branch
- 使用 Merge 形式提交代码
- 注意 Rebase 自己代码，保证 Codebase 与主 Branch 一致

---

# 编码准则

对类文件使用 [驼峰命名法](https://en.wikipedia.org/wiki/CamelCase)。包名使用 [小写连写](http://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html)，单词较多可以使用 `_` 分割符。

Project 中的 Module 尽量缩写，库可以使用 `lib-` 作为前缀。


### Property 定义与命名规范

对 Property 的定义应该放在文件的首位，并且遵守以下规范：

- 静态常量命名字母全部大写，单词之间用下划线分隔，且必须使用 `static final` 修饰
- Android 下的组件以及控件尽量以 **类型** 的缩写小写字母作为前缀，例如以下一些可选的前缀（可依此类推）：  

| Type           | Prefix   |
| -------------- | -------- |
| Activity       | `act`    |
| Fragment       | `frg`    |
| TextView       | `tv`     |
| EditText       | `et`     |
| Button         | `btn`    |
| RecyclerView   | `rv`     |


### Log 输出规范

使用 `Log` 类打印一些重要的信息对开发者而言是很重要的事情，切记不要使用 `Toast` 来做信息打印。

VERBOSE 和 DEBUG 类型的 Log 不应该出现在 Release 版本中，INFORMATION、WARNING 和 ERROR 类型的 Log 可以留下来，因为这些信息的输出能够帮助我们快速地定位问题所在，当然前提是，需要隐藏重要的信息输出，如，用户手机号，邮箱等。

只在 Debug 环境中输出日志的小技巧：

```kotlin
if (BuildConfig.DEBUG) Log.d(TAG, "The value of x is " + x)
```


### 类成员排序规范

关于这个并没有硬性要求，不过好的排序方式，能够提高可读性和易学性。这里给出一些排序建议：

1. 常量
2. 字段
3. 构造函数
4. 被重写的函数（不区分修饰符类型）
5. 被 `private` 修饰的函数
6. 被 `public` 修饰的函数
7. 被定义的内部类或者接口


## 资源文件（Resources）

- 资源等 `.xml` 文件应该采用 **小写字母_下划线** 的组合形式，并遵循前缀表明类型的习惯，形如 `type_name.xml`。
- `res/values` 目录下的文件可以任意命名，但前提是该文件能够明确表达职责所属，因为起作用的并不是文件本身，而是内部的标签属性。（例如你可以定义 `strings_home.xml`、`colors_home.xml` 之类的）


### Lyout 相关

- 布局（Layout）文件命名方式：

布局文件应该与 Android 组件的命名相匹配，以组件类型作为前缀，并且能够清晰的表达意图所在。基本规则如下：

| Component        | Class Name             | Layout Name                   |
| ---------------- | ---------------------- | ----------------------------- |
| Activity         | `UserProfileActivity`  | `activity_user_profile.xml`   |
| Fragment         | `SignUpFragment`       | `fragment_sign_up.xml`        |
| Dialog           | `ChangePasswordDialog` | `dialog_change_password.xml`  |
| AdapterView item | ---                    | `item_person.xml`             |
| Partial layout   | ---                    | `partial_stats_bar.xml`       |

值得一提的是，一些布局文件需要通过 `Adapter` 填充，如 `ListView`，`Recyclerview` 等列表视图，这种场景下，布局的命名应该以 `item_` 作为前缀。另外还有一种比较常见的情况，一个布局文件作为另一个布局文件的一部分而存在，或者使用了 `include`，`merge` 等标签的布局，可以使用 `partial_`、`include_` 或者 `merge_` 作为前缀，这一类布局的命名同样应该清晰的表达其意图。

- Id 命名方式：

控件 Id 的命名应该以该控件类型的缩写作为前缀，和 [代码中的控件名保持一致](https://github.com/nekocode/nekoblog/blob/master/AndroidDevGuideline.md#property-定义与命名规范)。

对于如何排版一个布局文件，请尽量遵循以下规范：

- 每个属性独占一行，缩进四个空格
- `android:id` 作为第一个属性存在
- 如果存在 `style` 属性，则紧随 `id` 之后
- 如果不存在 `style` 属性，则 `android:layout_xxx` 紧随 `id` 之后
- 当布局中的一个元素不再包含子元素时，另起一行，使用自闭合标签 `/>`，方便调整和添加新的属性
- 善用 IDE 的 Reformat Code 功能，尽量在编辑完 XML 文件后进行格式化

示例如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    >

    <TextView
        android:id="@+id/tvTitle"
        style="@style/FancyText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentRight="true"
        tools:text="This is title."
        />

    <include layout="@layout/partial_header" />

</LinearLayout>
```

- 避免层级冗余的嵌套。

Layout 结构优化方面，应尽量避免深层次的布局嵌套，这不仅会引发性能瓶颈，还会带来项目维护上的麻烦。在书写布局之前应该对 ViewTree 充分的分析，善用 [`<merge>`标签](http://stackoverflow.com/questions/8834898/what-is-the-purpose-of-androids-merge-tag-in-xml-layouts) 减少层级嵌套，或者使用 [Hierarchy Viewer](http://developer.android.com/intl/zh-cn/tools/help/hierarchy-viewer.html) 等 UI 优化工具对 Layout 进行分析与优化。可参考 [Optimizing Your UI](http://developer.android.com/intl/zh-cn/tools/debugging/debugging-ui.html) 与 [Optimizing Layout Hierarchies](http://developer.android.com/intl/zh-cn/training/improving-layouts/optimizing-layout.html)。


### Style、Theme 相关

Style 与 Theme 的命名统一使用 [驼峰命名法](https://en.wikipedia.org/wiki/CamelCase)（首字母大写）。使用多个 Style 文件而不是全部写在 `styles.cml` 里，如：`style_home.xml`，`style_item_details.xml`，`styles_forms.xml` 等。

几乎每个项目都需要适当的使用 Style 文件，因为对于一个视图来说有一个重复的外观是很常见的。在应用中对于大多数文本内容，最起码你应该有一个通用的 Style文 件，例如：

```xml
<style name="ContentText">
    <item name="android:textSize">@dimen/font_normal</item>
    <item name="android:textColor">@color/basic_black</item>
</style>
```

应用到 TextView 中:

```xml
<TextView
    style="@style/ContentText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/price"
    />
```

你或许需要为按钮控件做同样的事情，不要停止在那里。将一组相关的和重复的属性放到一个通用的 Style 中。

**对于控件的 `android:layout_xxx` 等属性应该在 Layout 中定义，同时其它属性 `android:xxx` 应放在 `style` 中。核心准则是保证 Layout 属性（position, margin, size 等）和 content 属性（text, src 等）在布局文件中，同时将所有的外观细节属性（color, padding, font）放在 Style 文件中。**


### 使用 Designtime Attributes（tools 标签）

- 布局预览应使用 `tools:xxx` 相关属性，避免 `android:text` 等硬编码的出现，具体可参考 [Designtime Attributes](http://tools.android.com/tips/layout-designtime-attributes)。示例如下：

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    tools:text="Home Link" 
    />
```


### Drawable 相关

- 常规 Drawable（图像）文件命名方式：

| Asset Type   | Prefix            |		Example          |
|--------------| ------------------|-----------------------------|
| Background   | `bg_`	           | `bg_splash.png`             |
| Button       | `btn_`	           | `btn_send_pressed.9.png`    |
| Divider      | `divider_`        | `divider_horizontal.9.png`  | 
| Icon         | `ic_`	           | `ic_star.png`               |


- 常规 icon（图标）文件命名方式：

| Asset Type                      | Prefix             | Example                      |
| --------------------------------| ----------------   | ---------------------------- |
| Icons                           | `ic_`              | `ic_star.png`                |
| Launcher icons                  | `ic_launcher`      | `ic_launcher_calendar.png`   |
| Menu icons and Action Bar icons | `ic_menu`          | `ic_menu_archive.png`        |
| Status bar icons                | `ic_stat_notify`   | `ic_stat_notify_msg.png`     |
| Tab icons                       | `ic_tab`           | `ic_tab_recent.png`          |
| Dialog icons                    | `ic_dialog`        | `ic_dialog_info.png`         |


- 常规 selector states（选中状态）文件命名方式：

| State	       | Suffix          | Example                     |
|--------------|-----------------|-----------------------------|
| Normal       | `_normal`       | `btn_order_normal.9.png`    |
| Pressed      | `_pressed`      | `btn_order_pressed.9.png`   |
| Focused      | `_focused`      | `btn_order_focused.9.png`   |
| Disabled     | `_disabled`     | `btn_order_disabled.9.png`  |
| Checked      | `_checked`      | `btn_order_checked.9.png`   |
| Selected     | `_selected`     | `btn_order_selected.9.png`  |
| Hovered      | `_hovered`      | `btn_order_hovered.9.png`   |
| Activated    | `_activated`    | `btn_order_activated.9.png` |

要注意的是，Selector 的一些状态是可以叠加的，所以可以产生 `btn_order_disabled_focused.9.png` 这类命名。

永远使用 [android-selector-chapek](https://github.com/inmite/android-selector-chapek) 这个插件来生成相应的 Selector Drawable XML 文件，而不应该手工创建。


### Color 相关

`colors.xml` 文件就像个 “调色板”，只映射颜色的 ARGB 值，不应该存在其他类型的数值，不要使用它为不同的按钮来定义 ARGB 值。应该像下面：

```xml
<resources>
    <!-- grayscale -->
    <color name="white"     >#FFFFFF</color>
    <color name="gray_light">#DBDBDB</color>
    <color name="gray"      >#939393</color>
    <color name="gray_dark" >#5F5F5F</color>
    <color name="black"     >#323232</color>

    <!-- basic colors -->
    <color name="green"     >#27D34D</color>
    <color name="blue"      >#2A91BD</color>
    <color name="orange"    >#FF9D2F</color>
    <color name="red"       >#FF432F</color>
</resources>
```

对同一色调，不同色域进行定义时，像 "brand_primary"、"brand_secondary"、 "brand_negative" 这样的命名也是不错的选择。

值得一提的是，这样规范的颜色很容易修改或重构，App 一共使用了多少种不同的颜色变会得非常清晰。


### Dimen 相关

我们应该像对待 `colors.xml` 一样对待 `dimens.xml` 文件，与定义颜色调色板无异，也应该定义一个规范字体大小的 **“字号板”**。

一个很好的建议：

```xml
<resources>

	<!-- font sizes -->
	<dimen name="font_larger">22sp</dimen>
	<dimen name="font_large">18sp</dimen>
	<dimen name="font_normal">15sp</dimen>
	<dimen name="font_small">12sp</dimen>

	<!-- typical spacing between two views -->
	<dimen name="spacing_huge">40dp</dimen>
	<dimen name="spacing_large">24dp</dimen>
	<dimen name="spacing_normal">14dp</dimen>
	<dimen name="spacing_small">10dp</dimen>
	<dimen name="spacing_tiny">4dp</dimen>

	<!-- typical sizes of views -->
	<dimen name="button_height_tall">60dp</dimen>
	<dimen name="button_height_normal">40dp</dimen>
	<dimen name="button_height_short">32dp</dimen>

</resources>
```

同样的，在定义 `margin` 和 `padding` 时，可以使用 `spacing_xxx` 作为前缀对其命名，而不是像对待 `String` 字符串那样直接写值。这样写的好处是，使组织结构和修改风格甚至布局变得非常容易。


### String 相关

String 命名的前缀应该能够清楚地表达它的功能职责，如，`registration_email_hint`，`registration_name_hint`。如果一个 Sting 不属于任何模块，这也就意味着它是通用的，应该遵循以下规范：


| Prefix             | Description                           |
| -----------------  | --------------------------------------|
| `error_`           | 错误提示                              |
| `msg_`             | 一般信息提示                          |
| `title_`           | 标题提示，如，Dialog标题              |
| `action_`          | 动作提示，如，“保存”，“取消”，“创建”  |

