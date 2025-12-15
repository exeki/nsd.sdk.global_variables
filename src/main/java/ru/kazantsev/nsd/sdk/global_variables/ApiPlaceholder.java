package ru.kazantsev.nsd.sdk.global_variables;

import org.slf4j.Logger;
import ru.naumen.core.server.rest.IRestApi;
import ru.naumen.core.server.script.api.*;
import ru.naumen.core.server.script.api.StringApi;
import ru.naumen.core.server.script.api.TransactionApi
import ru.naumen.core.server.script.api.push.INotificationApi;
import ru.naumen.core.server.script.spi.IScriptConditionsApi;
import ru.naumen.core.server.script.spi.IScriptUtils;
import ru.naumen.core.shared.userevents.UserEventActionResult;

import java.util.Map;

/*
 * не выгруженные
 * api.collections Работа с коллекциями
 * api.fileStorage Работа с файловыми хранилищами
 * api.filters Работа со скриптами фильтрации
 * api.fts Полнотекстовый поиск
 * api.keystore Работа с сертификатами
 * api.ldap Работа с LDAP
 * api.location Запрос геопозиции
 * api.logging Настройки минутной ротации логов
 * api.naming Правила нумерации объектов
 * api.navigation Работа с навигационным меню
 * api.quota Работа с квотами на количество объектов
 * api.search Работа с полнотекстовым поиском
 * api.serviceTime Работа с классами обслуживания
 * api.silentMode Работа с Silent Mode
 * api.sms Отправка SMS
 * api.soap Формирование запросов к SOAP сервисам
 * api.structure. Работа со структурами
 * api.systemUtils. Быстрое редактирование объектов
 * api.websocket Методы для работы с Websocket-каналом
 * api.wf Получение статуса и списка переходов
 * Работа с отчетами и печатными формами
 * api.cti интеграция с IP-телефонией
 * Методы API
 */

/**
 * Класс импортируется статически, что бы получить эмуляцию
 * глобальных переменных nsd
 */
@SuppressWarnings("unused")
public class ApiPlaceholder {

    /**
     * Апи, содержит в себе много других
     */
    public static Api api = new Api();
    /**
     * Утилитарный API
     */
    public static IScriptUtils utils = api.utils;
    /**
     * Логгер
     */
    public static Logger logger;

    /**
     * Параметры поиска (лимиты, параметры запроса) {@link ru.naumen.core.server.script.api.SearchParams}
     */
    public static ISearchParams sp;

    /**
     * Параметры поиска (условные операции) {@link ru.naumen.core.server.script.spi.ScriptConditionsApi}
     */
    public static IScriptConditionsApi op;

    /**
     * Модули системы
     * <p>Используется для обращения к скриптовому модулю и конкретному методу,
     * определенному в нем, с помощью конструкции: </p>
     * <code>modules.{код модуля}.{имя метода}({параметры метода}...);</code>
     */
    public static Map<String,Object> modules;

    /**
     * Плейсхолдер базового апи nsd
     */
    static class Api {

        /**
         * Работа с классами обслуживания
         */
        public static ServiceTimeApi serviceTime;
        /**
         * Работа с хранилищем пар "ключ-значение"
         */
        public static KeyValueStorageApi keyValue;
        /**
         * Работа с атрибутами
         */
        public static IAttributesApi attrs;

        /**
         * Работа с событиями календаря в формате ICS
         */
        public static ICalendarEventApi calendarEvent;

        /**
         * Получение контекста выполняемого действия:
         */
        public static IActionContextApi actionContext;

        /**
         * Работа с транзакциями {@link ru.naumen.core.server.script.api.TransactionApi}
         */
        public ITransactionApi tx;

        /**
         * Работа с метаинформацией {@link ru.naumen.core.server.script.api.MetainfoApi}
         */
        public IMetainfoApi metainfo;

        /**
         * Поиск объектов {@link ru.naumen.core.server.script.spi.ScriptUtils}
         * <ul>
         * <li>Работа с объектами</li>
         * <li>Работа с родительскими и дочерними объектами</li>
         * <li>Работа с атрибутами объекта</li>
         * <li>Работа с комментариями</li>
         * <li>Работа с файлами</li>
         * <li>Работа с шаблонами Groovy</li>
         * <li>Редактирование таблицы соответствий</li>
         * <li>Форматирование данных</li>
         * </ul>
         */
        public IScriptUtils utils;

        /**
         * Работа с временными характеристиками и счетчиками времени {@link ru.naumen.core.server.script.api.TimingApi}
         */
        public ITimingApi timing;

        /**
         * Формирование ссылок, ведущих в заданное место в интерфейсе {@link ru.naumen.core.server.script.api.WebApi}
         */
        public IWebApi web;

        /**
         * Персональные настройками сотрудника {@link ru.naumen.core.server.script.api.EmployeeApi}
         */
        public IEmployeeApi employee;

        /**
         * Работа с оргструктурой {@link ru.naumen.core.server.script.api.OuApi}
         */
        public IOuApi ou;

        /**
         * Работа с датами {@link ru.naumen.core.server.script.api.DateApi}
         */
        public IDateApi date;

        /**
         * Формирование ссылок для выполнения действий без перехода в интерфейс системы {@link ru.naumen.core.server.rest.RestApi}
         */
        public IRestApi rest;

        /**
         * Работа с кэшем @link ru.naumen.core.server.script.api.CacheApi}
         */
        public ICacheApi cache;

        /**
         * Работа с ключами авторизации {@link ru.naumen.core.server.script.api.AuthenticationApi}
         */
        public IAuthenticationApi auth;

        /**
         * Работа с правами {@link ru.naumen.core.server.script.api.SecurityApi}
         */
        public ISecurityApi security;

        /**
         * Отправка уведомления {@link ru.naumen.core.server.script.api.NotificationApi}
         */
        public INotificationApi notification;

        /**
         * Работа с планировщиком {@link ru.naumen.core.server.script.api.SchedulerApi}
         */
        public ISchedulerApi scheduler;

        /**
         * Формирование штрих-кодов {@link ru.naumen.core.server.script.api.BarcodeApi}
         */
        public IBarcodeApi barcode;

        /**
         * Использование запросов к базе данных {@link ru.naumen.core.server.script.api.DbApi}
         */
        public IDbApi db;

        /**
         * Шифрование и дешифрование {@link ru.naumen.core.server.script.api.EncrytionApi}
         */
        public IEncrytionApi encryption;

        /**
         * Формирование запросов к JSON сервисам {@link ru.naumen.core.server.script.api.HttpClientApi}
         */
        public IHttpClientApi http;

        /**
         * Работа с импортом {@link ru.naumen.core.server.script.api.AdvimportApi}
         */
        public IAdvimportApi advimport;

        /**
         * Обработка почты {@link ru.naumen.mailreader.server.processor.scripted.MailApi}
         */
        //реализация в
        public IMailApi mail;

        /**
         * Работа с типами {@link ru.naumen.core.server.script.api.TypesApi}
         */
        public TypesApi types;

        /**
         * Работа со строками {@link ru.naumen.core.server.script.api.StringApi}
         */
        public StringApi string;

    }
}
