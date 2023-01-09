import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {DbDataSource} from '../datasources';
import {Electores, ElectoresRelations} from '../models';

export class ElectoresRepository extends DefaultCrudRepository<
  Electores,
  typeof Electores.prototype.id,
  ElectoresRelations
> {
  constructor(
    @inject('datasources.db') dataSource: DbDataSource,
  ) {
    super(Electores, dataSource);
  }
}
