# petsalon
### what added
  - 4.15 21:14 
    - 后端 JpaRepository、Controller、MySQL
    - bug 暂时无法解决：Application run failed（entityManageFactory beans error???）
    - 前端 Owner、pet、service
    - config配置问题 List问题 payload??

  - 4.16 16:04
    - 后端 now we can visit localhost:8080/owner(pets or services) but data is null
    - bug resolved：boot version、lombok
    - prob：Link MySQL Data to Java
    - 前端
    - pages、list、layout created but data is assigned
    - prob: actions connect(how?)

  - 4.16 17:46
    - 后端newbug: 使用postman进行调试时出现：(Could not write JSON: Infinite recursion)
    
  - 4.16 20:09
    - bug (parly)resolved:
      - solution1: 应用@JsonBackReference&@JsonManagedReference，prob: 错误编号415，单纯使用backreference则无法同步owners且传送完pet相关联数据后，owners中的get报错
      - solution2: 应用@JsonIgnore，不会报错，但不会自动形成关联关系，需要手动将所有关系构建完整

  - 4.16 21:36
    - solution3: @JsonIgnoreProperties 单向成功, GET失败

  - 4.17 11:28
    - bug solved!!!!: 单项成功Get失败的原因：lombok.@Data与@JsonBackReference冲突，删去@Data
    - add restful, package: service, classes: Owner/Pet/ServiceResourceAssembler

  - 4.17 13:36
    - bug hateoas添加后，仅postman可正常操作，浏览器端error
    - solution: 回退至原版本(注释掉了RESTFUL的改动,assembler等)，暂时先进行前后端交互实现

  - 4.17 15:34
    - 数据交互跨域bug修复，现在可以前后端交互信息
    
  - 4.17 17:23
    - layout布局中修改button为menu，添加link方法，现在可通过menu切换三个页面
