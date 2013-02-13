package org.fsarmiento.league.maker.sample

import org.springframework.dao.DataIntegrityViolationException

class ChampionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [championInstanceList: Champion.list(params), championInstanceTotal: Champion.count()]
    }

    def create() {
        [championInstance: new Champion(params)]
    }

    def save() {
        def championInstance = new Champion(params)
        if (!championInstance.save(flush: true)) {
            render(view: "create", model: [championInstance: championInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'champion.label', default: 'Champion'), championInstance.id])
        redirect(action: "show", id: championInstance.id)
    }

    def show(Long id) {
        def championInstance = Champion.get(id)
        if (!championInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'champion.label', default: 'Champion'), id])
            redirect(action: "list")
            return
        }

        [championInstance: championInstance]
    }

    def edit(Long id) {
        def championInstance = Champion.get(id)
        if (!championInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'champion.label', default: 'Champion'), id])
            redirect(action: "list")
            return
        }

        [championInstance: championInstance]
    }

    def update(Long id, Long version) {
        def championInstance = Champion.get(id)
        if (!championInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'champion.label', default: 'Champion'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (championInstance.version > version) {
                championInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'champion.label', default: 'Champion')] as Object[],
                          "Another user has updated this Champion while you were editing")
                render(view: "edit", model: [championInstance: championInstance])
                return
            }
        }

        championInstance.properties = params

        if (!championInstance.save(flush: true)) {
            render(view: "edit", model: [championInstance: championInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'champion.label', default: 'Champion'), championInstance.id])
        redirect(action: "show", id: championInstance.id)
    }

    def delete(Long id) {
        def championInstance = Champion.get(id)
        if (!championInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'champion.label', default: 'Champion'), id])
            redirect(action: "list")
            return
        }

        try {
            championInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'champion.label', default: 'Champion'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'champion.label', default: 'Champion'), id])
            redirect(action: "show", id: id)
        }
    }
}
