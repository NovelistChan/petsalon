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
      - solution1: 应用@JsonBackReference&@JsonManagedReference，prob: 错误编号415，单纯使用backreference则无法同步owners且传送完pet相关联数据后，woners中的get报错
      - solution2: 应用@JsonIgnore，不会报错，但不会自动形成关联关系，需要手动将所有关系构建完整
