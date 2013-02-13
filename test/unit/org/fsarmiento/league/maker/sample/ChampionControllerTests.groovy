package org.fsarmiento.league.maker.sample



import org.junit.*
import grails.test.mixin.*

@TestFor(ChampionController)
@Mock(Champion)
class ChampionControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/champion/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.championInstanceList.size() == 0
        assert model.championInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.championInstance != null
    }

    void testSave() {
        controller.save()

        assert model.championInstance != null
        assert view == '/champion/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/champion/show/1'
        assert controller.flash.message != null
        assert Champion.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/champion/list'

        populateValidParams(params)
        def champion = new Champion(params)

        assert champion.save() != null

        params.id = champion.id

        def model = controller.show()

        assert model.championInstance == champion
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/champion/list'

        populateValidParams(params)
        def champion = new Champion(params)

        assert champion.save() != null

        params.id = champion.id

        def model = controller.edit()

        assert model.championInstance == champion
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/champion/list'

        response.reset()

        populateValidParams(params)
        def champion = new Champion(params)

        assert champion.save() != null

        // test invalid parameters in update
        params.id = champion.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/champion/edit"
        assert model.championInstance != null

        champion.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/champion/show/$champion.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        champion.clearErrors()

        populateValidParams(params)
        params.id = champion.id
        params.version = -1
        controller.update()

        assert view == "/champion/edit"
        assert model.championInstance != null
        assert model.championInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/champion/list'

        response.reset()

        populateValidParams(params)
        def champion = new Champion(params)

        assert champion.save() != null
        assert Champion.count() == 1

        params.id = champion.id

        controller.delete()

        assert Champion.count() == 0
        assert Champion.get(champion.id) == null
        assert response.redirectedUrl == '/champion/list'
    }
}
