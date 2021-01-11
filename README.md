# Medrick
Medrick Game Studio coding assignment for back-end developer
Question
1. What is the problem of the following code?
   List<String> list = new ArrayList<String>();
   list.add("A");
   list.add("B");
   for (int i = 0; i < list.size(); i++) {
   list.add(list.get(i).toUpperCase());
   }
باعث ایجاد یک حلقه بی پایان میشود و با پیغام خطای OutOfMemoryError روبرو میشویم
   
2.
همزمانی داده ها به معنای دسترسی همزمان بسیاری از کاربران به داده ها است.
برای رفع مسائلی از این دست به مفهومی تحت عنوان Synchronization نیاز داریم که معادل فارسی این واژه «هم‌زمانی» می‌باشد.

3.
Stereotype Annotations بر روی کلاس قرار می گیرند و باعث می شود Spring برای کلاس هایی که بر روی آنها Stereotype Annotations خورده یک bean جدید ایجاد کند و در حقیقت یک رابطه یک به یک بین کلاسی که Stereotype Annotation خورده و bean ایجاد شده وجود دارد و کنترل عملیات wiring در این حالت بسیار محدود و با چند انوتیشن مثل @Primary یا @Qualifier است.

اما @Bean این مزیت را دارد که تعریف bean را از تعریف کلاس مجزا می کند و به ما این اجازه را می دهد bean مورد نظر خودمون رو هر طوری که دلمون میخاد تنظیم کنیم و لزوما هم محدود به رابطه یک به یک بین bean و کلاس نباشیم. این انوتیشن بر روی متد قرار میگیرد (متد هایی که درون کلاس های Configuration قرار دارند) و خروجی متد یک bean است که توسط Spring Container مدیریت می شود.

4.
multithreading
اگر سبد خرید داشته باشم هندل کردن این سبد خرید.
اگر پرداخت آنلاین داشته باشم هندل کردن این پرداخت انلاین.