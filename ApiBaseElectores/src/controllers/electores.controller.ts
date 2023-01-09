import {authenticate} from '@loopback/authentication';
import {
  Count,
  CountSchema,
  Filter,
  FilterExcludingWhere,
  repository,
  Where
} from '@loopback/repository';
import {
  del, get,
  getModelSchemaRef, param, patch, post, put, requestBody,
  response
} from '@loopback/rest';
import {Electores} from '../models';
import {ElectoresRepository} from '../repositories';

@authenticate('jwt')
export class ElectoresController {
  constructor(
    @repository(ElectoresRepository)
    public electoresRepository : ElectoresRepository,
  ) {}

  @post('/electores')
  @response(200, {
    description: 'Electores model instance',
    content: {'application/json': {schema: getModelSchemaRef(Electores)}},
  })
  async create(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Electores, {
            title: 'NewElectores',
            exclude: ['id'],
          }),
        },
      },
    })
    electores: Omit<Electores, 'id'>,
  ): Promise<Electores> {
    return this.electoresRepository.create(electores);
  }

  @get('/electores/count')
  @response(200, {
    description: 'Electores model count',
    content: {'application/json': {schema: CountSchema}},
  })
  async count(
    @param.where(Electores) where?: Where<Electores>,
  ): Promise<Count> {
    return this.electoresRepository.count(where);
  }

  @get('/electores')
  @response(200, {
    description: 'Array of Electores model instances',
    content: {
      'application/json': {
        schema: {
          type: 'array',
          items: getModelSchemaRef(Electores, {includeRelations: true}),
        },
      },
    },
  })
  async find(
    @param.filter(Electores) filter?: Filter<Electores>,
  ): Promise<Electores[]> {
    return this.electoresRepository.find(filter);
  }

  @patch('/electores')
  @response(200, {
    description: 'Electores PATCH success count',
    content: {'application/json': {schema: CountSchema}},
  })
  async updateAll(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Electores, {partial: true}),
        },
      },
    })
    electores: Electores,
    @param.where(Electores) where?: Where<Electores>,
  ): Promise<Count> {
    return this.electoresRepository.updateAll(electores, where);
  }

  @get('/electores/{id}')
  @response(200, {
    description: 'Electores model instance',
    content: {
      'application/json': {
        schema: getModelSchemaRef(Electores, {includeRelations: true}),
      },
    },
  })
  async findById(
    @param.path.number('id') id: number,
    @param.filter(Electores, {exclude: 'where'}) filter?: FilterExcludingWhere<Electores>
  ): Promise<Electores> {
    return this.electoresRepository.findById(id, filter);
  }

  @patch('/electores/{id}')
  @response(204, {
    description: 'Electores PATCH success',
  })
  async updateById(
    @param.path.number('id') id: number,
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(Electores, {partial: true}),
        },
      },
    })
    electores: Electores,
  ): Promise<void> {
    await this.electoresRepository.updateById(id, electores);
  }

  @put('/electores/{id}')
  @response(204, {
    description: 'Electores PUT success',
  })
  async replaceById(
    @param.path.number('id') id: number,
    @requestBody() electores: Electores,
  ): Promise<void> {
    await this.electoresRepository.replaceById(id, electores);
  }

  @del('/electores/{id}')
  @response(204, {
    description: 'Electores DELETE success',
  })
  async deleteById(@param.path.number('id') id: number): Promise<void> {
    await this.electoresRepository.deleteById(id);
  }
}
