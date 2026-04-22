package br.com.fiap.Checkpoint2.service;

import br.com.fiap.Checkpoint2.model.OrderModel;
import br.com.fiap.Checkpoint2.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public OrderModel createOrder(OrderModel order){
        return repository.save(order);
    }
    public List<OrderModel> readAllOrders(){
        return  repository.findAll();
    }
    public OrderModel readOrderById(long id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrada"));
    }

    public OrderModel updateOrder(long id ,OrderModel order){
        return repository.findById(id)
                .map(existingOrder ->
                {
                    existingOrder.setClientName(order.getClientName());
                    existingOrder.setTotalValue(order.getTotalValue());
                    return repository.save(existingOrder);
                }).orElseThrow(()-> new EntityNotFoundException("Pedido não encontrado"));
    }

    public void deleteOrderById(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Pedido não encontrado");
        }
    }
}
