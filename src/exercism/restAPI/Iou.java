package exercism.restAPI;

/**
 * POJO representing an IOU.
 *
 * If this is in a user's "owed", then the user owes the person with { name} this { amount}.
 * If this is in a user's "owedBy", then { name} owes the user this { amount}.
 */

public class Iou {
    public final String name;
    public final double amount;

    public Iou(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
}
