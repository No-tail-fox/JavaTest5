// todo_organization.groovy
package script.db

databaseChangeLog(logicalFilePath: 'todo_organization.groovy') {
    changeSet(id: '2019-05-30-todo_organization', author: 'foxnotail@foxmail.com') {
        createTable(tableName: "TODO_ORGANIZATION") {
            column(name: 'ID', type: 'BIGINT UNSIGNED', remarks: 'ID', autoIncrement: true) {
                constraints(primaryKey: true)
            }
            column(name: 'objectVersionNumber', type: 'BIGINT', remarks: '版本号')
            column(name: 'name', type: 'VARCHAR(36)', remarks: '名称')
            column(name: 'code', type: 'VARCHAR(64)', remarks: '组织代码') {
            }
            column(name: 'address', type: 'VARCHAR(256)', remarks: '地址')
            column(name: "category", type: "VARCHAR(64)", defaultValue: "1")
            column(name: "ownerLoginName", type: "VARCHAR(64)", defaultValue: "1")
            column(name: "ownerRealName", type: "VARCHAR(64)", defaultValue: "1")
            column(name: "ownerEmail", type: "VARCHAR(64)", defaultValue: "1")
            column(name: "creationDate", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
        }
    }
}
